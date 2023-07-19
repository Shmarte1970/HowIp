import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class HowIP {
    public static void main(String[] args) {
       try {
            // URL del servicio para obtener la IP externa
            String url = "https://api.ipify.org";

            // Crear la conexión HTTP
            HttpURLConnection conexion = (HttpURLConnection) new URL(url).openConnection();

            // Configurar la solicitud y obtener la respuesta
            conexion.setRequestMethod("GET");
            int respuestaCodigo = conexion.getResponseCode();

            if (respuestaCodigo == HttpURLConnection.HTTP_OK) {
                // Leer la respuesta
                BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea;
                StringBuilder respuesta = new StringBuilder();

                while ((linea = lector.readLine()) != null) {
                    respuesta.append(linea);
                }

                lector.close();
                
                // Mostrar la dirección IP externa             
                
                String ipExterna = respuesta.toString();
                
                // Ruta del archivo
                
                String rutaArchivo = "historialIP.txt";
                
                // Escritura del Archivo
                
                BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo));
                escritor.write(ipExterna);
                
                //Cerrar escritura Archivo
                
                escritor.close();
                
                System.out.println("Tu dirección IP externa es: " + ipExterna);
            } else {
                System.out.println("Error al obtener la dirección IP externa. Código de respuesta: " + respuestaCodigo);
            }

            // Cerrar la conexión
            conexion.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

