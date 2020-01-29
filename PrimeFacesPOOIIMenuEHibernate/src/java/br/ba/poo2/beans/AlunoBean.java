/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.beans;

import br.ba.poo2.mapeamento.Aluno;
import br.ba.poo2.modelo.AlunoModelo;
import br.ba.poo2.rn.AlunoRN;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author André Portugal
 */
@ManagedBean(name = "alunoBean")
@SessionScoped
public class AlunoBean implements Serializable{
    AlunoRN alunoRN;
    
    
    private Aluno alunoSelecionado;
    private List<Aluno> alunos;
    private Aluno aluno;
    //private AlunoModelo modelo;
    
    private StreamedContent arquivoRetorno;
    private int tipoRelatorio;
    
    public void popularDataTable(){
        alunoRN = new AlunoRN();
        this.alunos = alunoRN.listarSemFiltro();
//        modelo = new AlunoModelo(alunos);
    }
    
    public AlunoBean() {
        aluno = new Aluno();
        popularDataTable();
    }

    public Aluno getAlunoSelecionado() {
        return alunoSelecionado;
    }

    public void setAlunoSelecionado(Aluno alunoSelecionado) {
        this.alunoSelecionado = alunoSelecionado;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
//    public AlunoModelo getModelo() {
//        return modelo;
//    }
//
//    public void setModelo(AlunoModelo modelo) {
//        this.modelo = modelo;
//    }
//    
    public void abrirDialog(){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('wdgdlgAl').show()");
        //requestContext.execute("PF('wdgdlgAl').show()"); no prime 5
    }
    public void abrirDialogAlt(){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('wdgdlgAlalt').show()");
    }
    
    
    public void salvar(){
        try {
            alunoRN = new AlunoRN();
            alunoRN.salvar(aluno);
            this.alunos = alunoRN.listarSemFiltro();
            aluno = new Aluno();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inclusão", "Aluno incluído com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha", "Ocorreu um erro na inclusão!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }
    public void alterar(){
        alunoRN = new AlunoRN();
        alunoRN.alterar(alunoSelecionado);
        this.alunos = alunoRN.listarSemFiltro();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração", "Aluno alterado com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    public void excluir(){
        alunoRN = new AlunoRN();
        alunoRN.excluir(alunoSelecionado);
        this.alunos = alunoRN.listarSemFiltro();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão", "Aluno excluído com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    


    public int getTipoRelatorio() {
        return tipoRelatorio;
    }

    public void setTipoRelatorio(int tipoRelatorio) {
        this.tipoRelatorio = tipoRelatorio;
    }

    
    

}
