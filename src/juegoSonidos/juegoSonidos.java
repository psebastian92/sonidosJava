package juegoSonidos;

import javax.sound.sampled.*;
import java.io.File;

public class juegoSonidos {

	public static void main(String[] args) {
		System.out.println("COMENZANDO EL JUEGO: ");

		// Esta ruta debe cambiarse segun donde este ubicado el archivo de sonido. Al
		// cambiar de PC, si o si cambia la ruta.
		String rutaSonidoInicio = "C:\\Users\\seeba\\eclipse-workspace\\sonidos\\src\\juegoAdivinanza\\sonido_inicio.wav";

		// Esta ruta debe cambiarse segun donde este ubicado el archivo de sonido. Al
		// cambiar de PC, si o si cambia la ruta.
		String rutaSonidoAcierto = "C:\\Users\\seeba\\eclipse-workspace\\sonidos\\src\\juegoAdivinanza\\sonido_acierto.wav";

		// Esta ruta debe cambiarse segun donde este ubicado el archivo de sonido. Al
		// cambiar de PC, si o si cambia la ruta.
		String rutaSonidoError = "C:\\Users\\seeba\\eclipse-workspace\\sonidos\\src\\juegoAdivinanza\\sonido_error.wav";

		reproducirSonido(rutaSonidoInicio); // Sonido de acierto al inicio del juego

		// Lógica del juego (aquí puedes poner tu propio juego)
		boolean jugadorGano = true; // Supongamos que el jugador ganó el juego

		// Emitir sonido de acuerdo al resultado del juego
		if (jugadorGano) {
			System.out.println("Respuesta correcta!");
			
			reproducirSonido(rutaSonidoAcierto); // Sonido de acierto si el jugador ganó
		} else {
			System.err.println("Respuesta incorrecta :(");

			reproducirSonido(rutaSonidoError); // Sonido de error si el jugador perdió
		}
	}

	public static void reproducirSonido(String rutaArchivo) {
		try {
			File archivo = new File(rutaArchivo);
			if (!archivo.exists()) {
				System.out.println("El archivo de sonido '" + rutaArchivo + "' no existe.");
				return;
			}

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
			AudioFormat format = audioInputStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(audioInputStream);
			clip.start();
			while (!clip.isRunning())
				Thread.sleep(10);
			while (clip.isRunning())
				Thread.sleep(10);
			clip.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
