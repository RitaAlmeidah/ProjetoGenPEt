package cadastro.menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import cadastro.modelo.CadastroAnimal;
//import cadastro.modelo.CadastroAnimalCachorro;
import cadastro.modelo.CadastroAnimalGato;

public class MetodosMenu 
{	
	int indiceCadastro = -1;
	float valorTotalDia, valorTotal, valor; 
	String lerString;
	int lerInteiro, numero;
	float lerFloat;
	/*Apagar lista Cadastro e colocar as listaCadastro.add(animalCachorro); como listaCadastroCachorro.add(animalCachorro)
	  Quando os Métodos da classe cachorro forem construídos*/
	ArrayList<CadastroAnimal> listaCadastro = new ArrayList<CadastroAnimal>();
	//ArrayList<CadastroAnimalCachorro> listaCadastroCachorro = new ArrayList<CadastroAnimalCachorro>();
	ArrayList<CadastroAnimalGato> listaCadastroGato = new ArrayList<CadastroAnimalGato>();
	
	public void cadastrar()
	{
		Scanner leia = new Scanner(System.in);
		CadastroAnimal ficha = new CadastroAnimal(null, null, null, null, null, null, null, null, 0.0f);
			
		System.out.print("\nNome tutor: ");
		lerString = leia.nextLine();
		ficha.setNomeDono(lerString);
		
		System.out.print("Numero do CPF: ");
		lerString = leia.nextLine();
		ficha.setCpf(lerString);
		
		System.out.print("Endereço: ");
		lerString = leia.nextLine();
		ficha.setEndereco(lerString);
		
		System.out.print("Nome do animal: ");
		lerString = leia.nextLine();
		ficha.setNomeAnimal(lerString);
		
		System.out.print("Cor do animal: ");
		lerString = leia.nextLine();
		ficha.setCor(lerString);
		
		System.out.print("Sexo do animal: ");
		lerString = leia.nextLine();
		ficha.setSexo(lerString);
		
		System.out.print("Idade do animal: ");
		lerString = leia.nextLine();
		ficha.setIdade(lerString);
		
		System.out.print("Peso do animal: ");
		lerFloat = leia.nextFloat();
		ficha.setPeso(lerFloat);
	
		System.out.print("Especie do animal: ");
		leia.skip("\\R?");
		lerString = leia.nextLine();
		ficha.setEspecie(lerString);
		
		if (ficha.getEspecie().equalsIgnoreCase("Gato")) 
		{
			CadastroAnimalGato fichaGato = new CadastroAnimalGato(null, null, null, null, null, 
					null, null, null, 0.0f, 0, null);
			
			List<String> tipoPelo = CadastroAnimalGato.getTipoPelo();
			System.out.println("\nEscolha o tipo de pelo: \n");
	        for (int indice = 0; indice < tipoPelo.size(); indice++) 
	        {
	            System.out.println((indice + 1) + " - " + tipoPelo.get(indice));
	        }
	        System.out.println("\n");
	        
	        System.out.print("Escolha o tipo de pelo:");
			lerInteiro = leia.nextInt();
			fichaGato.setPelo(lerInteiro);
			
			List<String> racas = CadastroAnimalGato.getRacas();
			System.out.println("\n\t\tRaças de Gatos: \n");
			for (int indice = 0; indice < racas.size(); indice++) 
			{
				int numero = indice + 1;
				String raca = racas.get(indice);
				System.out.println(numero + " - " + raca);
			}
			System.out.println("\n");
		
			System.out.print("Escolha o tipo de raça: ");
			lerInteiro = leia.nextInt();
			lerString = racas.get(lerInteiro-1);
			fichaGato.setRaca(lerString);
			
			CadastroAnimalGato animalGato = new CadastroAnimalGato(ficha.getNomeDono(), ficha.getEndereco(),
					ficha.getCpf(), ficha.getEspecie(), ficha.getNomeAnimal(), ficha.getCor(),
					ficha.getSexo(), ficha.getIdade(), ficha.getPeso(), fichaGato.getPelo(), 
					fichaGato.getRaca());	
			
			listaCadastroGato.add(animalGato);
			indiceCadastro += 1;
			
		//Alterar após finalização da classe cachorro
		}else if (ficha.getEspecie().equalsIgnoreCase("Cachorro")) 
		{
			CadastroAnimal animalCachorro = new CadastroAnimal(ficha.getNomeDono(), ficha.getEndereco(), ficha.getCpf(),
															ficha.getEspecie(), ficha.getNomeAnimal(), ficha.getCor(),
															ficha.getSexo(), ficha.getIdade(), ficha.getPeso());
			
			listaCadastro.add(animalCachorro);
			indiceCadastro += 1;
		}
	}
	
	//Print feito para testar se está puxando os dados do ultimo cadastro ou não
	public void printCadastro() 
	{
		CadastroAnimalGato ficha = listaCadastroGato.get(indiceCadastro);
		System.out.println("Peso: " + ficha.getPeso());
		System.out.println("Nome Dono: " + ficha.getNomeDono());
		System.out.println("Cor: " + ficha.getCor());
		System.out.println("Sexo: " + ficha.getSexo());
		System.out.println("Especie:" + ficha.getEspecie());
		System.out.println("Endereço:" + ficha.getEndereco());
		System.out.println("Idade: " + ficha.getIdade());
		System.out.println("Dono Cpf: " + ficha.getCpf());
		System.out.println("Nome Animal:" + ficha.getNomeAnimal());
		System.out.println("Tipo de Pelo " + ficha.getPelo());
		System.out.println("Raça:" + ficha.getRaca());
		
	}
	
	//Método Castrar 
	public void castrar() 
	{
		Iterator<CadastroAnimalGato> iFichaGato = listaCadastroGato.iterator();
		//Trocar depois para o CadastroAnimalCachorro
		Iterator<CadastroAnimal> iFichaCachorro = listaCadastro.iterator();
			
		if(iFichaGato.hasNext()) 
		{
			CadastroAnimalGato fichaGato = iFichaGato.next();
			if(fichaGato.getEspecie().equalsIgnoreCase("Gato")) 
			{
				valor = 400.00f;
				valorTotal += valor;
				valorTotalDia += valorTotal;
			}
		}else if (iFichaCachorro.hasNext()) 
		{
			CadastroAnimal fichaCachorro = iFichaCachorro.next();
			if(fichaCachorro.getEspecie().equalsIgnoreCase("Cachorro")) 
			{
				valor = 900.00f;
				valorTotal += valor;
				valorTotalDia += valorTotal;
			}
		}else 
		{
			System.out.println("Não tratamos essa especie de animal");
		}
			
	}
		
	//Método consulta
	public void consulta() 
	{
		valor = 200.00f;
		valorTotal += valor; 
		valorTotalDia += valorTotal;
	}
	
	//Método Metodo saída (Adaptar conforme o necessário)
	public void saidaAnimal() 
	{
		System.out.println("Valor total: " + valorTotal); 
		valorTotal = 0.0f; 
	}
	
}