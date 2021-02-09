package clusters;

public class FCM {

    final double datos[][] = {{1, 1}, {1, 3}, {1, 4}, {2, 2}, {2, 3}, {4, 1}, {6, 6}, {7, 7}, {7, 8}, {8, 5}, {8, 6}, {8, 1}};
    final double clusters[][] = {{4, 4}, {5, 4}};
    double distancia[][] = new double[12][2];
    double[][] pertenencia = new double[12][2];
    double[][] pertenencia2 = new double[12][2];
    double distancia2[][] = new double[12][2];

    public double CalculoDist(double x1, double x2, double y1, double y2) {
        double dist;
        dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return dist;
    }

    public double MatrizDistancia() {
        FCM dis = new FCM();
        for (int x = 0; x < datos.length; x++) {
            for (int y = 0; y < datos[x].length; y++) {
                distancia[x][y] = dis.CalculoDist(datos[x][0], clusters[y][0], datos[x][1], clusters[y][1]);
            }
        }
        for (int x = 0; x < distancia.length; x++) {
            for (int y = 0; y < distancia[x].length; y++) {
                System.out.println(distancia[x][y] + "\t");
            }
            System.out.println();
        }
        return 0;
    }

    public double MatrizPertenencia() {
        System.out.println("Matriz de Pertenencia");
        for (int x = 0; x < distancia.length; x++) {
            for (int y = 0; y <= 0; y++) {
                pertenencia[x][y] = 1 / ((Math.pow(distancia[x][0] / distancia[x][0], 2)) + (Math.pow(distancia[x][0] / distancia[x][1], 2)));
            }
            for (int y = 1; y <= 1; y++) {
                pertenencia[x][y] = 1 / ((Math.pow(distancia[x][1] / distancia[x][0], 2)) + (Math.pow(distancia[x][1] / distancia[x][1], 2)));
            }
        }
        for (int x = 0; x < pertenencia.length; x++) {
            for (int y = 0; y < pertenencia[x].length; y++) {
                System.out.println(pertenencia[x][y] + "\t");
            }
            System.out.println();
        }
        return 0;
    }

    public double NuevosCentroides() {
        double sumac = 0, sumac2 = 0, c1x = 0, c1y = 0, c2x = 0, c2y = 0;
        double cc1x, cc1y, cc2x, cc2y;
        for (int x = 0; x < pertenencia.length; x++) {
            for (int y = 0; y < pertenencia[x].length; y++) {
                pertenencia2[x][y] = Math.pow(pertenencia[x][y], 2);
            }
            sumac += pertenencia2[x][0];
            sumac2 += pertenencia2[x][1];
        }
        for (int x = 0; x < pertenencia2.length; x++) {
            c1x += pertenencia2[x][0] * datos[x][0];
            c1y += pertenencia2[x][0] * datos[x][1];
            c2x += pertenencia2[x][1] * datos[x][0];
            c2y += pertenencia2[x][1] * datos[x][1];
        }
        cc1x = c1x / sumac;
        cc1y = c1y / sumac;
        cc2x = c2x / sumac2;
        cc2y = c2y / sumac2;
        System.out.println("Nuevo centroides \n c1: " + "(" + cc1x + "," + cc1y + ")" + "\n" + "c2" + "(" + cc2x + "," + cc2y + ")");
        return 0;
    }

    public double FunciondeCosto() {
        double j1 = 0, j2 = 0, J;
        for (int x = 0; x < distancia.length; x++) {
            for (int y = 0; y < distancia[x].length; y++) {
                distancia2[x][y] = Math.pow(distancia[x][y], 2);
            }
        }
        for (int x = 0; x < distancia2.length; x++){
            j1 += pertenencia2[x][0] * distancia2[x][0];
            j2 += pertenencia2[x][1] * distancia2[x][1];
        }
        J = j1 + j2;
        
        System.out.println("Función de costo: " + J);
        return 0;
    }
}
