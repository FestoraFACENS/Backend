package com.example.festora.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	@OneToMany(mappedBy = "usuario")
	private List<Amizade> listaAmigos;
	
	@OneToMany(mappedBy = "organizador", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Evento> eventosCriados;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "usuario_evento", 
	joinColumns = @JoinColumn(name = "usuarios_id"),
	inverseJoinColumns = @JoinColumn(name = "eventos_id"))
	private List<Evento> eventosParticipados;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DataEspecial> datasDataEspeciais;
	
	@ManyToMany(mappedBy = "usuarios", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Notificacao> notificacoes;
	
	
	
	public void removerParticipacao(Evento evento) {
		this.eventosParticipados.remove(evento);
		evento.getParticipantes().remove(this);
	}
	
	public void removerNotificacao(Notificacao notificacao) {
		this.notificacoes.remove(notificacao);
		notificacao.getUsuarios().remove(this);
	}
}


