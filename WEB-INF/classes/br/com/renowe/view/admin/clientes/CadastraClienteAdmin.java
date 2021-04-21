package br.com.renowe.view.admin.clientes;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleCliente;
import br.com.renowe.controle.ValidaCnpj;
import br.com.renowe.controle.ValidaCpf;
import br.com.renowe.objetos.Cliente;

public class CadastraClienteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CadastraClienteAdmin() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getRequestDispatcher("clientes/cadastraCliente.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tpCadastro = request.getParameter("tpCadastro");
		String sexo = request.getParameter("sexo");
		String nome = request.getParameter("nome");
		String pf_pj = request.getParameter("pf_pj");
		String cpforcnpj = request.getParameter("cpforcnpj");
		String dtNasc = request.getParameter("dtNasc");
		String email = request.getParameter("email");
		String empresa = request.getParameter("empresa");
		String cep = request.getParameter("cep");
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String pais = request.getParameter("pais");
		String telefone = request.getParameter("telefone");
		String dddtelefone = request.getParameter("dddtelefone");
		String fax = request.getParameter("fax");
		String dddfax = request.getParameter("dddfax");
		String senha = request.getParameter("senha");
		String csenha = request.getParameter("csenha");
		String captcha = request.getParameter("captcha");

		List<String> erroMenssagen = new ArrayList<String>();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

		/* String erroMenssagen = null; */

		String erroTpCadastro = null;
		if (tpCadastro == null || tpCadastro.trim().equals("")) {
			erroTpCadastro = "*";
			erroMenssagen
					.add("Selecione o tipo de cadastro: Cliente ou Revendedor");
		}

		String erroSexo = null;
		if (sexo == null || sexo.trim().equals("")) {
			erroSexo = "*";
			erroMenssagen.add("Selecione o gênero(masculino ou feminino");
		}

		String erroNome = null;
		if (nome == null || nome.trim().equals("")) {
			erroNome = "*";
			erroMenssagen.add("Campo Nome deve ser informado");

		} else {
			if (nome.length() < 3) {
				erroNome = "*";
				erroMenssagen
						.add("Campo Nome deve ter o mmínimo de 3 caracteres");
			}
		}

		String erroPf_pj = null;
		if (pf_pj == null || pf_pj.trim().equals("")) {
			erroPf_pj = "*";
			erroMenssagen.add("Você deve escolher o tipo de Cliente");
		}

		String erroCpforcnpj = null;
		if (cpforcnpj == null || cpforcnpj.trim().equals("")) {
			erroCpforcnpj = "*";
			erroMenssagen.add("Você deve preencher o campo CPF/CNPJ");
		} else {
			if (pf_pj.equals("f")) {
				ValidaCpf cpf = new ValidaCpf();
				if (!cpf.validacpf(cpforcnpj)) {
					erroCpforcnpj = "*";
					erroMenssagen.add("Você deve informar um CPF válido");
				}

			} else {
				ValidaCnpj cnpj = new ValidaCnpj();
				if (!cnpj.validaCnpj(cpforcnpj)) {
					erroCpforcnpj = "*";
					erroMenssagen.add("Você deve informar um CNPJ válido");
				}

			}
		}

		String erroDtNasc = null;
		if (dtNasc == null || dtNasc.trim().equals("")) {
			erroDtNasc = "*";
			erroMenssagen.add("Data de Nascimento deve ser informada");
		} else {

		}

		String erroEmail = null;
		if (email == null || email.trim().equals("")) {
			erroEmail = "*";
			erroMenssagen.add("Você deve preencher o campo Email");
		} else {
			if (email.length() < 6) {
				erroMenssagen.add("Email deve ter o mínimo de 6 caracteres");
			}
		}
		String erroCep = null;
		if (cep == null || cep.trim().equals("")) {
			erroCep = "*";
			erroMenssagen.add("Cep deve ser informado");
		}

		String erroLogradouro = null;
		if (logradouro == null || logradouro.trim().equals("")) {
			erroLogradouro = "*";
			erroMenssagen.add("Logradouro deve ser informado");
		} else {
			if (logradouro.length() < 6) {
				erroMenssagen
						.add("Logradouro deve conter o mínimo de 6 caracteres");
			}
		}

		String erroNumero = null;
		if (numero == null || numero.trim().equals("")) {
			erroNumero = "*";
			erroMenssagen.add("Número deve ser informado");

		}

		String erroBairro = null;
		if (bairro == null || bairro.trim().equals("")) {
			erroBairro = "*";
			erroMenssagen.add("Bairro deve ser informado");
		}

		String erroCidade = null;
		if (cidade == null || cidade.trim().equals("")) {
			erroCidade = "*";
			erroMenssagen.add("Cidade deve ser informada");
		}

		String erroEstado = null;
		if (estado == null || estado.trim().equals("")) {
			erroEstado = "*";
			erroMenssagen.add("Estado deve ser informado");
		}

		String erroTelefone = null;
		String erroDddtelefone = null;
		if (telefone == null || telefone.trim().equals("")) {
			erroTelefone = "*";
			erroMenssagen.add("Telefone deve ser informado");
		} else {
			if (dddtelefone == null || dddtelefone.trim().equals("")) {
				erroDddtelefone = "*";
				erroMenssagen.add("DDD deve ser informado");

			}

		}

		String erroSenha = null;
		String erroCsenha = null;
		if (senha == null || senha.trim().equals("")) {
			erroSenha = "*";
			erroMenssagen.add("Senha deve ser informada");
		} else {
			if (senha.length() < 6) {
				erroSenha = "*";
				erroMenssagen.add("Senha deve conter no minimo 6 caracteres");

			} else {
				if (csenha == null || csenha.trim().equals("")) {
					erroCsenha = "*";
					erroMenssagen.add("Confirmação deve ser informada");
				} else {
					if (erroSenha == null && erroCsenha == null) {
						if (!senha.equals(csenha)) {
							erroCsenha = "*";
							erroMenssagen
									.add("O campo senha e a Confirmação devem ser iguais");
						}
					}
				}
			}
		}

		String erroCaptcha = null;
		if (captcha == null || captcha.trim().equals("")) {
			erroCaptcha = "Informe o valor da imagem";
		} else {
			String valorCaptcha = (String) request.getSession().getAttribute(
					"captcha");
			if (!captcha.equalsIgnoreCase(valorCaptcha)) {
				erroCaptcha = "Valor Diferente da Imagem";
			}
		}

		if (erroTpCadastro == null && erroSexo == null && erroNome == null
				&& erroPf_pj == null && erroCpforcnpj == null
				&& erroDtNasc == null && erroEmail == null && erroCep == null
				&& erroLogradouro == null && erroBairro == null
				&& erroCidade == null && erroEstado == null
				&& erroTelefone == null && erroSenha == null
				&& erroCsenha == null && erroCaptcha == null) {

			Date hoje = new Date();
			String dtCadastro = formatador.format(hoje);

			Cliente cliente = new Cliente();
			cliente.setTpCadastro(tpCadastro);
			cliente.setSexo(sexo);
			cliente.setNome(nome);
			cliente.setPf_pj(pf_pj);
			cliente.setCpforcnpj(cpforcnpj);
			cliente.setDtNasc(dtNasc);
			cliente.setEmail(email);
			cliente.setEmpresa(empresa);
			cliente.setCep(cep);
			cliente.setLogradouro(logradouro);
			cliente.setNumero(numero);
			cliente.setComplemento(complemento);
			cliente.setBairro(bairro);
			cliente.setCidade(cidade);
			cliente.setEstado(estado);
			cliente.setPais(pais);
			cliente.setTelefone(telefone);
			cliente.setDddtelefone(dddtelefone);
			cliente.setFax(fax);
			cliente.setDddfax(dddfax);
			cliente.setDtCadastro(dtCadastro);

			int id;
			try {
				id = ControleCliente.addCliente(cliente, senha);

				if (request.getSession(false) == null) {
					request.getSession().setAttribute("cliente", cliente);
					response.sendRedirect("../pedido/mostraCliente?id=" + id);
				} else {
					response.sendRedirect("home");
				}

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("erro", e);
				request.getRequestDispatcher("erro.jsp").forward(request,
						response);
			}
		} else {

			request.setAttribute("tpCadastro", tpCadastro);
			request.setAttribute("sexo", sexo);
			request.setAttribute("nome", nome);
			request.setAttribute("pf_pj", pf_pj);
			request.setAttribute("cpforcnpj", cpforcnpj);
			request.setAttribute("dtNasc", dtNasc);
			request.setAttribute("email", email);
			request.setAttribute("empresa", empresa);
			request.setAttribute("cep", cep);
			request.setAttribute("logradouro", logradouro);
			request.setAttribute("numero", numero);
			request.setAttribute("complemento", complemento);
			request.setAttribute("bairro", bairro);
			request.setAttribute("cidade", cidade);
			request.setAttribute("estado", estado);
			request.setAttribute("pais", pais);
			request.setAttribute("telefone", telefone);
			request.setAttribute("dddtelefone", dddtelefone);
			request.setAttribute("fax", fax);
			request.setAttribute("dddfax", dddfax);
			request.setAttribute("captcha", "");

			request.setAttribute("erroTpCadastro", erroTpCadastro);
			request.setAttribute("erroSexo", erroSexo);
			request.setAttribute("erroNome", erroNome);
			request.setAttribute("erroPf_pj", erroPf_pj);
			request.setAttribute("erroCpforcnpj", erroCpforcnpj);
			request.setAttribute("erroDtNasc", erroDtNasc);
			request.setAttribute("erroEmail", erroEmail);
			request.setAttribute("erroCep", erroCep);
			request.setAttribute("erroLogradouro", erroLogradouro);
			request.setAttribute("erroNumero", erroNumero);
			request.setAttribute("erroBairro", erroBairro);
			request.setAttribute("erroCidade", erroCidade);
			request.setAttribute("erroEstado", erroEstado);
			request.setAttribute("erroTelefone", erroTelefone);
			request.setAttribute("erroDddtelefone", erroDddtelefone);

			request.setAttribute("erroSenha", erroSenha);
			request.setAttribute("erroCsenha", erroCsenha);

			request.setAttribute("erroCaptcha", erroCaptcha);
			request.setAttribute("erroMenssagen", erroMenssagen);

			doGet(request, response);

		}

	}
}
