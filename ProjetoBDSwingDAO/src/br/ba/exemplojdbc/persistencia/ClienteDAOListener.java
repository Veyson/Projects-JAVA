/*
 * ClienteDAOListener.java
 *
 * Created on 18 de Dezembro de 2008, 19:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.ba.exemplojdbc.persistencia;

import br.ba.exemplojdbc.beans.ClienteBeans;
import java.util.List;

/**
 *
 * @author Portugal
 */
public interface ClienteDAOListener {
    /**
     * M�todo que atualiza os dados na tabela cliente
     * 
     * @param cliente - recebe o objeto ClienteBeans
     * @throws java.lang.Exception se n�o for poss�vel atualizar
     */
    void atualizar(ClienteBeans cliente) throws Exception;

    /**
     * M�todo que exclui uma linha na tabela cliente
     * 
     * @param cliente - recebe o objeto ClienteBeans
     * @throws se n�o for poss�vel excluir o cliente
     */
    void excluir(ClienteBeans cliente) throws Exception;

    /**
     * M�todo respons�vel por pesquisar um cliente
     * 
     * @param id - recebe um Inteiro como par�metro para pesquisar
     * pelo campo codigo
     * @return objeto ClienteBeans
     * @throws java.lang.Exception se n�o for poss�vel retornar o objeto cliente
     */
    ClienteBeans procurarCliente(Integer id) throws Exception;

    void salvar(ClienteBeans cliente) throws Exception;

    /**
     * M�todo que retorna todos os clientes
     * 
     * @return objeto List
     * @throws java.lang.Exception se n�o for poss�vel retornar o objeto List
     */
    List todosClientes() throws Exception;
   
    public List todasCategorias( )  throws Exception;
}
