package bethaCode.javaspringideaparcelamentoonLine.util;

public class validaCnpj {

    public static void main(String[] args) {
        String valorcnpj  = "35.001.466/1332-34";
        valorcnpj  = valorcnpj.replace(".","");
        valorcnpj  = valorcnpj.replace("-","");
        valorcnpj  = valorcnpj.replace("/","");
        int digito1 = 0  ;
        int digito2 = 0 ;
        int multiplicadordigito1 = 5 ;
        int numeroConvertido = 0;
        int multiplicadordigito2 = 6 ;

        char[] cnpjSemdigito = valorcnpj.toCharArray();
        for (int x = 0; x < 12; x++) {
            numeroConvertido = Integer.parseInt(String.valueOf(cnpjSemdigito[x]) );
            numeroConvertido = numeroConvertido * multiplicadordigito1;
            multiplicadordigito1 --;
            if (multiplicadordigito1 <= 1){
                multiplicadordigito1 = 9 ;
            }
            digito1 = digito1 + numeroConvertido ;
        }
        digito1 = 11 - (digito1 % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }

        String primeiroDigito = valorcnpj.substring(0,12) + (digito1 + "");

        System.out.println(primeiroDigito);


        char[] cnpjSemdigito2 = primeiroDigito.toCharArray() ;
        for (int x = 0; x < 13; x++) {
            numeroConvertido = Integer.parseInt(String.valueOf(cnpjSemdigito2[x]) );
            numeroConvertido = numeroConvertido * multiplicadordigito2;
            multiplicadordigito2 --;
            if (multiplicadordigito2 <= 1){
                multiplicadordigito2 = 9 ;
            }
            digito2 = digito2 + numeroConvertido ;
        }
        digito2 =  (digito2 % 11);
        digito2 = 11 - digito2;
        if (digito2 > 9) {
            digito2 = 0;
        }else {
            digito2 = digito2 ;
        }
        String cnpjValido = valorcnpj.substring(0,12) + (digito1 + "") + (digito2 + "");

        System.out.println(valorcnpj);
        System.out.println(cnpjValido);

        if(cnpjValido.equals(valorcnpj)){
            System.out.println( " O cnpj : " + cnpjValido + " é válido ");
        }

    }
}
