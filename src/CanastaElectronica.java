import java.util.Date;
public class CanastaElectronica {
    Double montoTotal=0.00;

    IPayment payment;
    IPersistence persistence;

    public CanastaElectronica(IPayment payment,IPersistence persistence) {
        this.payment = payment;
        this.persistence = persistence;
    }

    public void generarFactura(Factura factura) {
        payment.pay(factura);
        persistence.guardar(factura);
    }
}

interface IPayment {
    void pay(Factura factura);
}

interface IPersistence {
    void guardar(Factura factura);
}

class PaymentPayPal implements IPayment {

    @Override
    public void pay(Factura factura) {
        System.out.println("Factura pagada con paypal");
    }
}
class PaymentTC implements IPayment{

    @Override
    public void pay(Factura factura) {
        System.out.println("Factura con TC");
    }
}

class Persistencia  implements IPersistence{
    @Override
    public void guardar(Factura factura) {
        System.out.println("Guardar factura");
    }
}
class Factura {
    String nombreCliente;
    Date fecha;
}