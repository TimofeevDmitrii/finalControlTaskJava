package Service;

import Data.ToyStoreElement;

import java.io.IOException;

public interface CreateToyElement {
    ToyStoreElement createToyElement(String toyData) throws IOException;
}
