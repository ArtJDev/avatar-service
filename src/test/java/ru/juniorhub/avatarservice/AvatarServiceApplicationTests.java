package ru.juniorhub.avatarservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dasniko.testcontainers.keycloak.KeycloakContainer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.juniorhub.avatarservice.entities.Avatar;

import java.util.HexFormat;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("integration")
//@Testcontainers
class AvatarServiceApplicationTests {


	// User
//	private static KeycloakToken janeTokens;
//	// User and admin
//	private static KeycloakToken tomTokens;
//
//	@Autowired
//	private WebTestClient webTestClient;
//
//	@Container
//	private static final KeycloakContainer keycloakContainer = new KeycloakContainer("quay.io/keycloak/keycloak:21.0.2")
//			.withRealmImportFile("test-realm-config.json");
//
//	@DynamicPropertySource
//	static void dynamicProperties(DynamicPropertyRegistry registry) {
//		registry.add("spring.security.oauth2.resourceserver.jwt.issuer-uri",
//				() -> keycloakContainer.getAuthServerUrl() + "realms/JuniorHub");
//	}
//
//	@BeforeAll
//	static void generateAccessTokens() {
//		WebClient webClient = WebClient.builder()
//				.baseUrl(keycloakContainer.getAuthServerUrl() + "realms/JuniorHub/protocol/openid-connect/token")
//				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//				.build();
//		tomTokens = authenticateWith("admin", "password", webClient);
//		janeTokens = authenticateWith("user", "password", webClient);
//	}
//
//	@Test
//	void whenGetRequestThenAvatarReturned() {
//		String username = "admin";
//		Avatar avatarToCreate = Avatar.of(username, "file", HexFormat.of().parseHex("e04fd020ea3a6910a2d808002b30309d"));
//		Avatar expectedAvatar = webTestClient
//				.post()
//				.uri("/avatar")
//				.headers(headers -> headers.setBearerAuth(tomTokens.accessToken()))
//				.bodyValue(avatarToCreate)
//				.exchange()
//				.expectStatus().isCreated()
//				.expectBody(Avatar.class).value(avatar -> assertThat(avatar).isNotNull())
//				.returnResult().getResponseBody();
//
//		webTestClient
//				.get()
//				.uri("/avatar")
//				.exchange()
//				.expectStatus().is2xxSuccessful()
//				.expectBody(Avatar.class).value(actualAvatar -> {
//					assertThat(actualAvatar).isNotNull();
//					assertThat(actualAvatar.username()).isEqualTo(expectedAvatar.username());
//				});
//	}
//
//	@Test
//	void whenPostRequestThenAvatarCreated() {
//		var expectedAvatar = Avatar.of("artem", "file", HexFormat.of().parseHex("e04fd020ea3a6910a2d808002b30309d"));
//
//		webTestClient
//				.post()
//				.uri("/avatar")
//				.headers(headers -> headers.setBearerAuth(tomTokens.accessToken()))
//				.bodyValue(expectedAvatar)
//				.exchange()
//				.expectStatus().isCreated()
//				.expectBody(Avatar.class).value(actualAvatar -> {
//					assertThat(actualAvatar).isNotNull();
//					assertThat(actualAvatar.username()).isEqualTo(expectedAvatar.username());
//				});
//	}
//
//	@Test
//	void whenPostRequestUnauthenticatedThen401() {
//		var expectedAvatar = Avatar.of("petya", "file", HexFormat.of().parseHex("e04fd020ea3a6910a2d808002b30309d"));
//
//		webTestClient
//				.post()
//				.uri("/avatar")
//				.bodyValue(expectedAvatar)
//				.exchange()
//				.expectStatus().isUnauthorized();
//	}
//
//	@Test
//	void whenGetRequestUnauthorizedThen403() {
//
//		webTestClient
//				.get()
//				.uri("/avatar/all")
//				.headers(headers -> headers.setBearerAuth(janeTokens.accessToken()))
//				.exchange()
//				.expectStatus().isForbidden();
//	}
//
//	@Test
//	void whenPutRequestThenAvatarUpdated() {
//		var username = "john";
//		var avatarToCreate = Avatar.of(username, "file", HexFormat.of().parseHex("e04fd020ea3a6910a2d808002b30309d"));
//		Avatar createdAvatar = webTestClient
//				.post()
//				.uri("/avatar")
//				.headers(headers -> headers.setBearerAuth(tomTokens.accessToken()))
//				.bodyValue(avatarToCreate)
//				.exchange()
//				.expectStatus().isCreated()
//				.expectBody(Avatar.class).value(Avatar -> assertThat(Avatar).isNotNull())
//				.returnResult().getResponseBody();
//		var avatarToUpdate = new Avatar(createdAvatar.id(), createdAvatar.username(), createdAvatar.filename(),
//				createdAvatar.type(), createdAvatar.size(), createdAvatar.avatar());
//
//		webTestClient
//				.put()
//				.uri("/avatar/")
//				.headers(headers -> headers.setBearerAuth(tomTokens.accessToken()))
//				.bodyValue(avatarToUpdate)
//				.exchange()
//				.expectStatus().isOk()
//				.expectBody(Avatar.class).value(actualAvatar -> {
//					assertThat(actualAvatar).isNotNull();
//					assertThat(actualAvatar.username()).isEqualTo(avatarToUpdate.username());
//				});
//	}
//
//	@Test
//	void whenDeleteRequestThenAvatarDeleted() {
//		var username = "jack";
//		var avatarToCreate = Avatar.of(username, "file", HexFormat.of().parseHex("e04fd020ea3a6910a2d808002b30309d"));
//		webTestClient
//				.post()
//				.uri("/avatar")
//				.headers(headers -> headers.setBearerAuth(tomTokens.accessToken()))
//				.bodyValue(avatarToCreate)
//				.exchange()
//				.expectStatus().isCreated();
//
//		webTestClient
//				.delete()
//				.uri("/avatar")
//				.headers(headers -> headers.setBearerAuth(tomTokens.accessToken()))
//				.exchange()
//				.expectStatus().isNoContent();
//
//		webTestClient
//				.get()
//				.uri("/avatar")
//				.headers(headers -> headers.setBearerAuth(tomTokens.accessToken()))
//				.exchange()
//				.expectStatus().isNotFound()
//				.expectBody(String.class).value(errorMessage ->
//						assertThat(errorMessage).isEqualTo("Аватар пользователя " + username + " не найден")
//				);
//	}
//
//	private static KeycloakToken authenticateWith(String username, String password, WebClient webClient) {
//		return webClient
//				.post()
//				.body(BodyInserters.fromFormData("grant_type", "password")
//						.with("client_id", "juniorhub-test")
//						.with("username", username)
//						.with("password", password)
//				)
//				.retrieve()
//				.bodyToMono(KeycloakToken.class)
//				.block();
//	}
//
//	private record KeycloakToken(String accessToken) {
//
//		@JsonCreator
//		private KeycloakToken(@JsonProperty("access_token") final String accessToken) {
//			this.accessToken = accessToken;
//		}
//	}
}
