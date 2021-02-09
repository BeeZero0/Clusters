package clusters;

public class Clusters {

    public static void main(String[] args) {
//        HCM prueba = new HCM();
//        prueba.MatrizDistancia();
//        prueba.MatrizMembresia();
//        prueba.NuevosCentroides();
//        prueba.FunciondeCosto();
        
        FCM prueba2 = new FCM();
        prueba2.MatrizDistancia();
        prueba2.MatrizPertenencia();
        prueba2.NuevosCentroides();
        prueba2.FunciondeCosto();
    }
}
