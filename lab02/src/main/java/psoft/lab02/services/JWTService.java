package psoft.lab02.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.stereotype.Service;
import psoft.lab02.entities.user.User;
import psoft.lab02.filter.TokenFilter;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.Optional;

@Service
public class JWTService {
    private UserService usuariosService;
    private final String TOKEN_KEY = "login do batman";


    public JWTService(UserService usuariosService) {
        super();
        this.usuariosService = usuariosService;
    }

    public boolean usuarioExiste(String authorizationHeader) throws ServletException {
        String subject = getSujeitoDoToken(authorizationHeader);
        return usuariosService.getUser(subject).isPresent();
    }

    public boolean usuarioTemPermissao(String authorizationHeader, String email) throws ServletException {
        String subject = getSujeitoDoToken(authorizationHeader);
        Optional<User> optUsuario = usuariosService.getUser(subject);
        return optUsuario.isPresent() && optUsuario.get().getEmail().equals(email);
    }

    private String getSujeitoDoToken(String authorizationHeader) throws ServletException {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new ServletException("Token inexistente ou mal formatado!");
        }

        // Extraindo apenas o token do cabecalho.
        String token = authorizationHeader.substring(TokenFilter.TOKEN_INDEX);

        String subject = null;
        try {
            subject = Jwts.parser().setSigningKey("login do batman").parseClaimsJws(token).getBody().getSubject();
        } catch (SignatureException e) {
            throw new ServletException("Token invalido ou expirado!");
        }
        return subject;
    }

    public String geraToken(String email) {
        return Jwts.builder().setSubject(email)
                .signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
                .setExpiration(new Date(System.currentTimeMillis() + 3 * 60 * 1000)).compact();//3 min
    }
}
