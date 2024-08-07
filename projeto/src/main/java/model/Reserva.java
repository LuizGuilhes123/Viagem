package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A data da reserva é obrigatória")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataReserva;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @NotNull(message = "O usuário é obrigatório")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "viagem_id", nullable = false)
    @NotNull(message = "A viagem é obrigatória")
    private Viagem viagem;

    @NotEmpty(message = "O status é obrigatório")
    @Column(nullable = false)
    private String status;
}
