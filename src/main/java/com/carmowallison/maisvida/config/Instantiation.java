package com.carmowallison.maisvida.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.carmowallison.maisvida.domain.Cidade;
import com.carmowallison.maisvida.domain.Especialidade;
import com.carmowallison.maisvida.domain.Estado;
import com.carmowallison.maisvida.domain.Medico;
import com.carmowallison.maisvida.domain.User;
import com.carmowallison.maisvida.domain.enums.Perfil;
import com.carmowallison.maisvida.repository.CidadeRepository;
import com.carmowallison.maisvida.repository.EspecialidadeRepository;
import com.carmowallison.maisvida.repository.EstadoRepository;
import com.carmowallison.maisvida.repository.MedicoRepository;
import com.carmowallison.maisvida.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private BCryptPasswordEncoder bc;

	@Override
	public void run(String... args) throws Exception {

		// EXCLUIR TODA A BASE
		userRepository.deleteAll();
		estadoRepository.deleteAll();
		cidadeRepository.deleteAll();
		especialidadeRepository.deleteAll();
		medicoRepository.deleteAll();

		// CRIA NOVA BASE

		// BLOCO USUARIOS
		User wallison = new User(null, "Wallison", "wallisoncarmo@gmail.com", true, bc.encode("123"));
		wallison.addPerfil(Perfil.ADMIN);

		User yasmin = new User(null, "yasmin", "yasmin@gmail.com", false, bc.encode("123"));
		User lucy = new User(null, "lucy", "lucy@gmail.com", true, bc.encode("123"));

		userRepository.saveAll(Arrays.asList(wallison, yasmin, lucy));

		// BLOCO ESTADOS
		Estado e1 = new Estado(null, "Distrito Federal", true);
		Estado e2 = new Estado(null, "Rio de Janeiro", true);
		Estado e3 = new Estado(null, "São Paulo", true);

		estadoRepository.saveAll(Arrays.asList(e1, e2, e3));

		// BLOCO CIDADE
		Cidade c1 = new Cidade(null, "Brasília", true);
		Cidade c2 = new Cidade(null, "Taguatinga", true);
		Cidade c3 = new Cidade(null, "Ceilândia", true);

		Cidade c4 = new Cidade(null, "Campinas", true);
		Cidade c5 = new Cidade(null, "Taguatinga", true);
		Cidade c6 = new Cidade(null, "Ceilândia", true);

		Cidade c7 = new Cidade(null, "Petrópolis", true);
		Cidade c8 = new Cidade(null, "Angra dos Reis", true);
		Cidade c9 = new Cidade(null, "Duque de Caxias", true);

		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9));

		// BLOCO EPECIALIDADE
		Especialidade s1 = new Especialidade(null, "Cardiologia", true);
		Especialidade s2 = new Especialidade(null, "Dermatologia", true);
		Especialidade s3 = new Especialidade(null, "Ortopedista", true);

		especialidadeRepository.saveAll(Arrays.asList(s1, s2, s3));

		// BLOCO MEDICOS
		Medico m1 = new Medico(null, "Alice", "Costa", "Alice@email.com", true, true);
		Medico m2 = new Medico(null, "Sophia ", "Costa ", "Sophia @email.com", true, true);
		Medico m3 = new Medico(null, "Helena", "Costa", "Helena@email.com", true, true);
		Medico m4 = new Medico(null, "Valentina", "Costa", "Valentina@email.com", true, true);
		Medico m5 = new Medico(null, "Laura", "Costa", "Laura@email.com", true, true);
		Medico m6 = new Medico(null, "Isabella", "Costa", "Isabella@email.com", true, true);
		Medico m7 = new Medico(null, "Manuela", "Costa", "Manuela@email.com", true, true);
		Medico m8 = new Medico(null, "Júlia", "Costa", "Júlia@email.com", true, true);
		Medico m9 = new Medico(null, "Heloísa", "Costa", "Heloísa@email.com", true, true);
		Medico m10 = new Medico(null, "Luiza", "Costa", "Luiza@email.com", true, true);
		Medico m11 = new Medico(null, "Maria Luiza", "Maria_LuizaCosta", "@email.com", true, true);
		Medico m12 = new Medico(null, "Lorena", "Costa", "Lorena@email.com", true, true);
		Medico m13 = new Medico(null, "Lívia", "Costa", "Lívia@email.com", true, true);
		Medico m14 = new Medico(null, "Giovanna", "Costa", "Giovanna@email.com", true, true);
		Medico m15 = new Medico(null, "Beatriz", "Costa", "@email.com", true, true);
		Medico m16 = new Medico(null, "Maria Clara", "Costa", "Maria_Clara@email.com", true, true);
		Medico m17 = new Medico(null, "Clara", "Costa", "Clara@email.com", true, true);
		Medico m18 = new Medico(null, "Maria", "Costa", "Maria@email.com", true, true);
		Medico m19 = new Medico(null, "Luiza", "Costa", "Luiza@email.com", true, true);
		Medico m20 = new Medico(null, "Cecília", "Costa", "Cecilia@email.com", true, true);
		Medico m21 = new Medico(null, "Isadora", "Costa", "Isadora@email.com", true, true);
		Medico m22 = new Medico(null, "Mariana", "Costa", "Mariana@email.com", true, true);
		Medico m23 = new Medico(null, "Emanuelly", "Costa", "Emanuelly@email.com", true, true);
		Medico m24 = new Medico(null, "Ana Júlia", "Costa", "Ana_Julia@email.com", true, true);
		Medico m25 = new Medico(null, "Miguel", "Costa", "Miguel@email.com", true, true);
		Medico m26 = new Medico(null, "Arthur", "Costa", "Arthur@email.com", true, true);
		Medico m27 = new Medico(null, "Bernardo", "Costa", "Bernardo@email.com", true, true);
		Medico m28 = new Medico(null, "Heitor", "Costa", "Heitor@email.com", true, true);
		Medico m29 = new Medico(null, "Davi", "Costa", "Davi@email.com", true, true);
		Medico m30 = new Medico(null, "Lorenzo", "Costa", "Lorenzo@email.com", true, true);
		Medico m31 = new Medico(null, "Théo", "Costa", "Théo@email.com", true, true);
		Medico m32 = new Medico(null, "Pedro", "Costa", "Pedro@email.com", true, true);
		Medico m33 = new Medico(null, "Gabriel", "Costa", "Gabriel@email.com", true, true);
		Medico m34 = new Medico(null, "Enzo", "Costa", "Enzo@email.com", true, true);
		Medico m35 = new Medico(null, "Matheus", "Costa", "Matheus@email.com", true, true);
		Medico m36 = new Medico(null, "Lucas", "Costa", "Lucas@email.com", true, true);
		Medico m37 = new Medico(null, "Benjamin", "Costa", "Benjamin@email.com", true, true);
		Medico m38 = new Medico(null, "Nicolas", "Costa", "Nicolas@email.com", true, true);
		Medico m39 = new Medico(null, "Guilherme", "Costa", "Guilherme@email.com", true, true);
		Medico m40 = new Medico(null, "Rafael", "Costa", "Rafael@email.com", true, true);
		Medico m41 = new Medico(null, "Joaquim", "Costa", "Joaquim@email.com", true, true);
		Medico m42 = new Medico(null, "Samuel", "Costa", "Samuel@email.com", true, true);
		Medico m43 = new Medico(null, "Enzo Gabriel", "Costa", "Enzo_Gabriel@email.com", true, true);
		Medico m44 = new Medico(null, "João Miguel", "Costa", "João_Miguel@email.com", true, true);
		Medico m45 = new Medico(null, "João", "Costa", "joao@email.com", true, true);
		Medico m46 = new Medico(null, "Henrique", "Costa", "henrique@email.com", true, true);
		Medico m47 = new Medico(null, "Gustavo", "Costa", "Gustavo@email.com", true, true);
		Medico m48 = new Medico(null, "Murilo", "Costa", "Murilo@email.com", true, true);
		Medico m49 = new Medico(null, "Pedro Henrique", "Costa", "Pedro_Henrique@email.com", true, true);
		Medico m50 = new Medico(null, "Pietro", "Costa", "Pietro@email.com", true, true);

		medicoRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16,
				m17, m18, m19, m20, m21, m22, m23, m24, m25, m26, m27, m28, m29, m30, m31, m32, m33, m34, m35, m36, m37,
				m38, m39, m40, m41, m42, m43, m44, m45, m46, m47, m48, m49, m50));

	}

}
