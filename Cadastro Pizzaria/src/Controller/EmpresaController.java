package Controller;

import Model.empresa.Cliente;
import Model.empresa.Empresa;
import Model.empresa.Produto;

public class EmpresaController {
    public static Empresa empresa;

    public static void setRoot(Cliente c) {
        empresa.tree.root = empresa.tree.insert(empresa.tree.root, c);
    }


    public static Cliente procuraCliente() {
        

        return null;
    }
}
