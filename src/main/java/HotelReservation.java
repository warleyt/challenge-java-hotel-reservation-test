public class HotelReservation {
    public String getCheapestHotel(String input) {

        float[][][] matriz = new float[3][2][2];

        /* dim 1 = 3 hoteis (com respectivas classificações, que são "posição+3")
                0 - Lakewood; 1 = Bridgewood; 2 = Ridgewood;
        *  dim 2 = dia de semana (0) ou fds (1)
        *  dim 3 = cliente normal (0) ou fidelizados (1)
        * */
        matriz[0][0][0] = 110;
        matriz[0][0][1] = 80;
        matriz[0][1][0] = 90;
        matriz[0][1][1] = 80;

        matriz[1][0][0] = 160;
        matriz[1][0][1] = 110;
        matriz[1][1][0] = 60;
        matriz[1][1][1] = 50;

        matriz[2][0][0] = 220;
        matriz[2][0][1] = 100;
        matriz[2][1][0] = 150;
        matriz[2][1][1] = 40;

        String[] strings = input.split(":");
        int numDiaSemana = 0;
        int numFDS = 0;

        String[] dias = strings[1].split("[(]");

        for (int i = 1; i < dias.length; i++) {
            switch (dias[i].substring(0,2)){
                case "mo":
                case "tu":
                case "we":
                case "th":
                case "fr":
                    numDiaSemana++;
                    break;
                case "sa":
                case "su":
                    numFDS++;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid day of the week: " + dias[i].substring(0,2));
            }
        }

        int posHotelBarato = 0;
        int tipoCliente = 0;

        if(strings[0].charAt(2)=='w'){
            tipoCliente=1;
        }

        float somaMenorPreco = matriz[0][0][tipoCliente]*numDiaSemana+matriz[0][1][tipoCliente]*numFDS;

        for (int i = 1; i <= 2; i++) {
            if(matriz[i][0][tipoCliente]*numDiaSemana+matriz[i][1][tipoCliente]*numFDS
                    <= somaMenorPreco){
                somaMenorPreco=matriz[i][0][tipoCliente]*numDiaSemana+matriz[i][1][tipoCliente]*numFDS;
                posHotelBarato = i;
            }
        }

        if(posHotelBarato==0){
            return "Lakewood";
        }else if(posHotelBarato==1){
            return "Bridgewood";
        }else{
            return "Ridgewood";
        }
    }
}
