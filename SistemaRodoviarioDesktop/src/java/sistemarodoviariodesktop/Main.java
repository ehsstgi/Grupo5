/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviariodesktop;

import GUI.LoginGUI;
import java.lang.String;


/**
 *
 * @author Bruno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
               
       new LoginGUI().setVisible(true);
               /**try {
                   InitialContext context = new InitialContext();
                   DataHoraSessionBeanRemote bean = (DataHoraSessionBeanRemote)context.lookup("ejb/DataHora");
                   DataHora dh = bean.retornaUltimoSalvo();
                   System.out.println(dh.getIdDataHora());
                       
            /**Parada parada;
            LinhaSessionBeanRemote linhaBean = (LinhaSessionBeanRemote)context.lookup("ejb/Linha");
            ParadaSessionBeanRemote paradaBean = (ParadaSessionBeanRemote)context.lookup("ejb/Parada");
            CidadeSessionBeanRemote cidadeBean = (CidadeSessionBeanRemote)context.lookup("ejb/Cidade");
            Linha linhaIda, linhaVolta;
            linhaIda = linhaBean.retornaLinhaToda("São Paulo", "Campinas");
            
            linhaVolta = linhaBean.retornaLinhaToda("Campinas", "São Paulo");
            Cidade cidade = cidadeBean.cidadePeloNome("Campinas");
            parada = new Parada (linhaIda, cidade);
            paradaBean.salvar(parada);
            cidade = cidadeBean.cidadePeloNome("São Paulo");
            parada = new Parada (linhaVolta, cidade);
            paradaBean.salvar(parada);
            //int[] itens = paradaList.getSelectedIndices();
            //for (int i = 0; i <= itens.length; i++) {
                //Object sel = paradaList.getModel().getElementAt(itens[i]);
                cidade = cidadeBean.cidadePeloNome("Jundiaí");
                parada = new Parada(linhaIda, cidade);
                paradaBean.salvar(parada);
                parada = new Parada(linhaVolta, cidade);
                paradaBean.salvar(parada);**/
           // } catch (Exception e) {}
       /**try {
            InitialContext context = new InitialContext();
            LinhaSessionBeanRemote beanLinha = (LinhaSessionBeanRemote) context.lookup("ejb/Linha");
            CidadeSessionBeanRemote beanCidade = (CidadeSessionBeanRemote) context.lookup("ejb/Cidade");
            //AssentoSessionBeanRemote assentobean = (AssentoSessionBeanRemote)context.lookup("ejb/Assento");
            //Linha linha = bean.retornaLinha("São Paulo", "Bauru");
            //DataHora dh = bean.retornaDataHora(linha, "25/05/2012", "12:00");
            List<Object[]> resultado = beanLinha.todasLinhas();
           for (Object[] objects : resultado) {
               String s = objects[3].toString();
               Cidade cidadeOrigem = beanCidade.findCidade(Long.parseLong(s));
               s = objects[2].toString();
               Cidade cidadeDestino = beanCidade.findCidade(Long.parseLong(s));
               System.out.println(cidadeOrigem.getCidadeNome()+" - "+cidadeDestino.getCidadeNome());
           }
        }
        
        catch (Exception e) {}**/
     }
}
     
        
        
        
    
    
/**try { InitialContext context = new InitialContext();//LISTA DE COISAS HEHEHE
        CidadeSessionBeanRemote bean = (CidadeSessionBeanRemote)context.lookup("ejb/Cidade");
        List<Object[]> resultado = bean.retornaCidades("São Paulo", "Bauru");
        for (Object[] objects : resultado) {
            String itemLista = objects[1].toString();
            System.out.print(itemLista);
          }
        
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);}
    }
}**/


        
        //Linha l;        
        //String s;
        //try { InitialContext context = new InitialContext();        
        //LinhaSessionBeanRemote bean = (LinhaSessionBeanRemote)context.lookup("ejb/Linha");
        //s = bean.retornaTrajeto("São Paulo", "Barueri");
        //System.out.println(s);
        //t = bean.retornaTrajetoPorId(101L);
        //System.out.print(t.getDataFim());
        //Long id = Long.parseLong(s);
        //List<Object[]> resultado = bean.retornaTrajetos("São Paulo", "Barueri");
        //for (Object[] objects : resultado) {
        //System.out.println(objects[1].toString());
        //}
        //}
        //catch (Exception ex) {
            //Logger.getLogger (Main.class.getName()).log(Level.SEVERE, null, ex);}
        //}
//}

        
       /** try {
            InitialContext context = new InitialContext();
            LinhaSessionBeanRemote bean = (LinhaSessionBeanRemote) context.lookup("ejb/Linha");
            Linha linha = bean.retornaLinha("São Paulo", "Barueri");
            System.out.println("A linha "+linha.getCidadeOrigem().getCidadeNome()+"-"+linha.getCidadeDestino().getCidadeNome()+" custa R$ "+linha.getPreco()+",00");
            List<Object[]> resultado = bean.retornaPorLinha(linha.getIdLinha());
            if (resultado.isEmpty()) {System.out.println("vazio, baby");}
            for (Object[] objects : resultado) {
                System.out.println ("Datas:" + objects[1].toString());                
            }
            for (Object[] objects : resultado) {
                System.out.println ("Horas:" + (String)objects[2]);                
            } //catch (Exception ex) { }**/
            
            //Cidade cidade = new Cidade ("Salvador");
            //estado = estadobean.findEstado(3L);
            //System.out.println(estado.getNomeEstado());
            //List lista = estado.getCidadeList();
            //lista.add(cidade);
            //estado.setCidadeList(lista);
            //cidade.setEstadoFk(estado);
            //bean.salvar(cidade);
        //} catch (Exception ex) { } 
    ///} 
//}/**
        

        
        /**try { InitialContext context = new InitialContext();//LISTA DE COISAS HEHEHE
        EstadoSessionBeanRemote bean = (EstadoSessionBeanRemote)context.lookup("ejb/Estado");
        List<Object[]> resultado = bean.retornaEstados();
        for (Object[] objects : resultado) {
            System.out.print("\n"+(String)objects[1]);
        }
        
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);}**/
        
                  /**try { InitialContext context; context = new InitialContext();
          FuncionarioSessionBeanRemote bean = (FuncionarioSessionBeanRemote)
          context.lookup("ejb/Funcionario");    
         
          Funcionario f = new Funcionario("Bruno Rivas", "bruninho", "buborc");
         
          bean.salvar(f);
          System.out.print ("USUARIO CRIADO!");         
         
          } catch (Exception ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); }
}
}**/
         
         
                 /**
         * InitialContext context; try { context = new InitialContext();
         * ClienteSessionBeanRemote bean = (ClienteSessionBeanRemote)
         * context.lookup("ejb/Cliente"); String s;
         *
         * s = bean.validaLogin("marclo", "123");
         *
         *
         * System.out.println(s);
         *
         * Cliente c = new Cliente("jaca1234", "jaca", "aaa"); bean.salvar(c);
         * Cliente cli = bean.getCliente1((long) 251);
         * System.out.println(cli.getNome());
         *
         *
         *
         *
         *
         *
         * List est = bean2.listarCidades(); for(int i=0;i<est.size();i++)
         * System.out.print(est.get(i).) = bean2;
         *
         *
         *
         * *
         *
         *
         * } catch (Exception ex) {
         * Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); }
         **/




