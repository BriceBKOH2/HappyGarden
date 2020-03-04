package diginamic.happygarden.exception;

public class FileStorageException extends RuntimeException {

	private static final long serialVersionUID = -24038770500043904L;

	public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
