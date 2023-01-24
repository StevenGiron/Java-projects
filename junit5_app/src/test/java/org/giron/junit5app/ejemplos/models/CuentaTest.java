package org.giron.junit5app.ejemplos.models;


import org.giron.junit5app.ejemplos.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {
    Cuenta cuenta;

    @BeforeEach
    void initMetodotest() {
        this.cuenta = new Cuenta("Steven Giron", new BigDecimal("1000.12345"));
        System.out.println("Iniciando el metodo");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finalizando metodo");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Iniciando test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando test");
    }

    @Test
    @DisplayName("Probando el nombre de la cuenta")
//    @Disabled //Deshabilita el test, no lo ejecuta
    void testNombreCuenta() {
//        fail(); //fuerza el error del test
//        cuenta.setPersona("Andres");
        String esperado = "Steven Giron";
        String actual = cuenta.getPersona();
        assertNotNull(actual, () -> "La cuenta no puede ser nula"); //con una expresion lambda el mensaje no se construye si el assert no falla, mas optimo
        assertEquals(esperado, actual, () -> "El nombre de la cuenta no es el que se esperaba: ".concat("se esperaba ")
                .concat(esperado).concat(" y se obtuvo ").concat(actual));
        assertTrue(actual.equals(esperado), () -> "nombre de la cuenta esperada debe ser igual a la real");
    }

    @Test
    @DisplayName("Probando el saldo de la cuenta que sea mayor que cero y no null")
    void testSaldoCuenta() {
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @DisplayName("Testeando referencias que sean iguales con el metodo equals")
    void testReferenciaCuenta() {
        this.cuenta = new Cuenta("Steven Giron", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("Steven Giron", new BigDecimal("8900.9997"));

//        assertNotEquals(cuenta2, cuenta); //comparación por referencia
        assertEquals(cuenta2, cuenta); //se sobreescribio el metodo equals para comparar por valores y no por referencia
    }

    @Test
    void testDebitoCuenta() {
        this.cuenta = new Cuenta("Steven Giron", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal("100"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("Steven Giron", new BigDecimal("1000.12345"));
        cuenta.credito(new BigDecimal("100"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void dineroInsuficienteExceptionCuenta() {
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1500));
        });
        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual);
    }

    @Test
    void testTransferirDineroCuentas() {
        Cuenta cuentaOrigen = new Cuenta("Steven Giron", new BigDecimal("3000"));
        Cuenta cuentaDestino = new Cuenta("Sebastian Arcila", new BigDecimal("1500.12345"));
        Banco banco = new Banco();
        banco.setNombre("Bancolombia");
        banco.transferir(cuentaOrigen, cuentaDestino, new BigDecimal(500));
        assertEquals("2500", cuentaOrigen.getSaldo().toPlainString());
        assertEquals("2000.12345", cuentaDestino.getSaldo().toPlainString());
    }

    @Test
    void testRelacionBancoCuentas() {
        Cuenta cuentaOrigen = new Cuenta("Steven Giron", new BigDecimal("3000"));
        Cuenta cuentaDestino = new Cuenta("Sebastian Arcila", new BigDecimal("1500.12345"));

        Banco banco = new Banco();
        banco.addCuenta(cuentaOrigen);
        banco.addCuenta(cuentaDestino);
        banco.setNombre("Bancolombia");
        banco.transferir(cuentaOrigen, cuentaDestino, new BigDecimal(500));

        assertAll(
                () -> assertEquals("2500", cuentaOrigen.getSaldo().toPlainString()),
                () -> assertEquals("2000.12345", cuentaDestino.getSaldo().toPlainString()),
                () -> assertEquals(2, banco.getCuentas().size()),
                () -> assertEquals("Bancolombia", cuentaOrigen.getBanco().getNombre()),
                () -> assertEquals("Steven Giron", banco.getCuentas().stream()
                        .filter(cuenta -> cuenta.getPersona().equals("Steven Giron"))
                        .findFirst()
                        .get().getPersona()),
                () -> assertTrue(banco.getCuentas().stream()
                        .filter(cuenta -> cuenta.getPersona().equals("Steven Giron"))
                        .findFirst().isPresent()),
                () -> assertTrue(banco.getCuentas().stream()
                        .anyMatch(cuenta -> cuenta.getPersona().equals("Steven Giron"))));
    }

    @Nested //Clases de test anidadas, sirve para organizar los tests
    class SistemaOperativoTest {

        @Test
        @EnabledOnOs(OS.WINDOWS)
            //Se ejecuta si el sistema operativo es windows
        void testSoloWindows() {
        }

        @Test
        @EnabledOnOs({OS.LINUX, OS.MAC})
            //Se ejecuta si el sistema operativo es linux o mac
        void testSoloLinuxMac() {
        }

        @Test
        @DisabledOnOs(OS.WINDOWS)
            //Se ejecuta si el sistema operativo no es windows
        void testNoWindows() {
        }
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void soloJdk8() {
    }

    @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
    @ValueSource(strings = {"100", "200", "300", "500", "700", "1000"})
    void testDebitoCuentaParametrizado(String monto) { //Se pasa por parametro los valores establecidos con el mismo tipo
        this.cuenta = new Cuenta("Steven Giron", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
    @CsvSource({"200, 100, Steven, Steven",
            "250, 200, Juan, Juan",
            "300, 300, Pepe, Pepe",
            "510, 500, Luis, Luisa",
            "750, 700, Diego, Diego",
            "1000, 1000, Santi, Dani"})
    void testDebitoCuentaParametrizadoCsvSource(String saldo, String monto, String esperado, String actual) { //Se pasa por parametro los valores establecidos con el mismo tipo
        cuenta.setSaldo(new BigDecimal(saldo));
        cuenta.debito(new BigDecimal(monto));
        cuenta.setPersona(actual);
        assertEquals(esperado, actual);
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
    @CsvFileSource(resources = "/data.csv")
    void testDebitoCuentaParametrizadoCsvFileSource(String monto) { //Se pasa por parametro los valores establecidos con el mismo tipo
        this.cuenta = new Cuenta("Steven Giron", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    static List<String> montoList() {
        return Arrays.asList("100", "200", "300", "500", "700", "1000");
    }

    @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
    @MethodSource("montoList")
    void testDebitoCuentaParametrizadoMethodSource(String monto) { //Se pasa por parametro los valores establecidos con el mismo tipo
        this.cuenta = new Cuenta("Steven Giron", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @Timeout(5) //despues de los segundos establecidos falla la prueba
    void pruebaTimeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(6);
    }

    @Test
    @Timeout(value = 5000, unit = TimeUnit.MILLISECONDS) //despues de los segundos establecidos falla la prueba
    void pruebaTimeOut2() throws InterruptedException {
        TimeUnit.SECONDS.sleep(6);
    }
}