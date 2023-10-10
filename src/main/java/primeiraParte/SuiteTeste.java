package primeiraParte;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import primeiroDesafioPaginaLocal.PreenchimentoComSucesso;
import primeiroDesafioPaginaLocal.TesteBaseadoEmParametros;
@RunWith(Suite.class) // Aqui está uma forma de rodar  os teste sem precisar acessar a sua class
// desse modo fica mais facil para gerenciar as class de teste
@SuiteClasses({
	TesteBaseadoEmParametros.class,
	PreenchimentoComSucesso.class
})
public class SuiteTeste {
	
	// O runwith é um runner do Junit 

}
