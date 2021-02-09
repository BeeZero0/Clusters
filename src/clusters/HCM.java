package clusters;

public class HCM {

    Double distancia[][];
    Double membresia[][];

    public Double CalculoDist(Double x1, Double x2, Double y1, Double y2) {
        Double dist;
        dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return dist;
    }

    public Double[][] MatrizDistancia(Double datos[][], Double clusters[][]) {
        HCM dis = new HCM();
        int datl, clul;
        datl = datos.length;
        clul = clusters.length;
        distancia = new Double[datl][clul];
        for (int x = 0; x < datos.length; x++) {
            for (int y = 0; y < clusters.length; y++) {
                distancia[x][y] = dis.CalculoDist(datos[x][0], clusters[y][0], datos[x][1], clusters[y][1]);
            }
        }
        return distancia;
    }

    public Double [][] MatrizMembresia( Double distancia[][]) {
        int datlx, datly;
        datlx = distancia.length;
        datly = distancia[0].length;
        membresia = new Double[datlx][datly];
        for (int x = 0; x < distancia.length; x++) {
            if (distancia[x][0] > distancia[x][1]) {
                membresia[x][1] = 1.0;
                membresia[x][0] = 0.0;
            } else {
                membresia[x][1] = 0.0;
                membresia[x][0] = 1.0;
            }
        }
        return membresia;
    }

    public Double[][] NuevosCentroides(Double datos[][], Double membresia[][]) {
        int memx, memy, ceny;
        ceny = 2;
        memx = membresia.length;
        memy = membresia[0].length;
        Double[] g = new Double[memy];
        Double[][] cont = new Double[memy][ceny];
        Double[][] ncen = new Double[memy][ceny];

        
        for (int x = 0; x < membresia.length; x++) {
            for (int y = 0; y < membresia[0].length; y++) {
                if (membresia[x][y] == 1) {
                    g[y]++;
                    cont[y][0] += datos[x][0];
                    cont[y][1] += datos[x][1];
                }
            }
        }        
        for (int x1 = 0; x1 < memy; x1++){
            for(int y1 = 0; y1 < ceny; y1++){
                ncen[x1][y1] = ((1 / g[x1]) * cont[x1][y1]);
            }
        }
        
        return ncen;
    }

    public double FunciondeCosto() {
        double j1 = 0, j2 = 0, J;
        for (int x = 0; x < membresia.length; x++) {
            if (membresia[x][0] == 1) {
                j1 += distancia[x][0];
            }
            if (membresia[x][1] == 1) {
                j2 += distancia[x][1];
            }
        }
        J = j1 + j2;
        System.out.println("Función de costo: " + J);
        return 0;
    }
}
