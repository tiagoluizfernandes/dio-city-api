package br.com.tts.diocidadesapi.exception;

/**
 * @author Tiago Luiz Fernandes
 */

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super("Not found");
    }

}
