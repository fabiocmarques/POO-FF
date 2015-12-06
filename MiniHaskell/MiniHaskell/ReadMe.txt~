	****************************************************
	*                  MiniHaskell                     *
	*                                                  *
	****************************************************

  Versão aprimorada da linguagem MiniHaskell feita em sala.

** Para executar o interpretador
	1) Importar o projeto MiniHaskell no eclipse
	2) Executar o arquivo InterpretadorMH do pacote br.unb.cic.poo.MiniHaskell.parser

** Instruções implementadas
	Os seguintes comandos podem ser utilizados na linha de comando:

	-> soma exp1 exp2
		* Realiza a soma dos resultados das subexpressões exp1 e exp2

	-> mult exp1 exp2
		* Realiza a multiplicacao dos resultados das subexpressões exp1 e exp2
	-> let var = expAt in expCorpo
		* Avalia o resultado de expCorpo com o valor de expAt atribuido a variável var.

	-> func nomeDaFuncao (arg1 arg2 ... argn) (expCorpo)
		* Declara uma funcao nomeDaFuncao que recebe os argumentos arg1 arg2 ... argn e retorna o 
		  resultado da expressao de expCorpo.

	-> eval nomeDaFuncao (arg1 arg2 ... argn)
		* Avalia a função nomeDaFuncao com os valores arg1 arg2 ... argn

	-> equals exp1 exp2
		* retorna true se os resultados de exp1 e exp2 são iguais, caso contrario retorna falso.

	-> maior exp1 exp2
		* retorna true se exp1 for maior que exp2, caso contrário retorna false.

	-> menor exp1 exp2
		* retorna true se exp1 for menor que exp2, caso contrário retorna false.

	-> maior_eq exp1 exp2
		* retorna true se exp1 for maior ou igual a exp2, caso contrário retorna false.

	-> menor_eq exp1 exp2
		* retorna true se exp1 for menor ou igual a exp2, caso contrário retorna false.

	-> if condExp then expThen else expElse
		* Se o resultado de condExp for true, retorna o resultado de expThen, caso contrário retorna o 
		  resultado de expElse.

	-> neg exp
		* multiplica o resultado de exp por -1.

	-> lista
		* retorna uma lista vazia.

	-> inserir expAt in expLista
		* retorna uma nova lista com o resultado de expAt no inicio da lista obtida com expLista.

	-> get expIndex from expLista
		*retorna a uma lista obtida de expLista da posição indicada pelo resultado de expIndex.

	-> valor of explista
		*retorna o valor armazenado no primeiro elemento da lista retornada por expLista.

	-> size of expLista
		*retorna o tamanho da lista obtida de expLista.

** Diferenças para a versão implementada em sala

	* Funções recursivas podem ser implementadas
		Ex:

		func fatorial (n) (
			if menor_eq n 1 then
				1
			else
				mult n eval fatorial (soma n neg 1)
		)

	* Expressão agora é uma classe abstrata, entretanto, se o método aceitar não for sobrescrito um comportamento padrão dos
	  visitor será chamado.

	* Tipo lista foi adicionado, bem como expressões que as manipulam.

	* Os visitors implementados em sala estão funcionais.

	* Expressoes de comparação foram implementadas.

	* As Expressoes let e aplicação de função primeiro avaliam as suas atribuições iniciais e somente depois criam seu ambiente 
          de execução. Isso foi feito para se corrigir um erro em que as atribuições eram realizadas de forma errônea.

	* Um interpretador capaz de receber receber código e avaliar as expressões correspondentes a eles.

	* Erros não interrompem o funcionamento do programa, um tratamento de exceções simples foi implementado.

	* Testes para diversas expressoes criadas foram efetuados para avaliar o seu funcionamento.

