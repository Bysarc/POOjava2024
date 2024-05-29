package Parcial3;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface IFabricaDeTrajes {
    void añadirComponenteAAlmacen() throws IdException, MuchoExtracomunitarioException, MangaException, IOException;
    List<Componente> listarComponentes(); //lista en la coleccion componentes (listar)
    Optional<Componente> obtenerComponente(Predicate<Componente> criterio);
    void actualizarComponente(Componente componenteAntiguo, Componente componenteNuevo) throws IdException, MuchoExtracomunitarioException, MangaException, IOException;
    void eliminarComponente(Componente componente) throws IOException;

    void añadirTrajeAAlmacen() throws ColoresException, TallaException, TrajeYaExisteException, IOException;
    List<Traje> listarTrajes();
    Optional<Traje> obtenerTraje(Predicate<Traje> criterio);
    // void actualizarTraje(Traje trajeAntiguo, Traje trajeNuevo) throws ColoresException, TallaException, TrajeYaExisteException, IOException;
    void eliminarTraje(Traje traje) throws IOException;

    void activarDesactivarRebajas() throws IOException;
    void crearEnvio() throws IOException;
    void consultarEnvio();
    void eliminarTrajeDelAlmacen() throws IOException;

    // Excepciones internas
    public class IdException extends Exception {
        public IdException(String message) {
            super(message);
        }
    }

    public class MuchoExtracomunitarioException extends Exception {
        public MuchoExtracomunitarioException(String message) {
            super(message);
        }
    }

    public class MangaException extends Exception {
        public MangaException(String message) {
            super(message);
        }
    }

    public class ColoresException extends Exception {
        public ColoresException(String message) {
            super(message);
        }
    }

    public class TallaException extends Exception {
        public TallaException(String message) {
            super(message);
        }
    }

    public class TrajeYaExisteException extends Exception {
        public TrajeYaExisteException(String message) {
            super(message);
        }
    }
}
