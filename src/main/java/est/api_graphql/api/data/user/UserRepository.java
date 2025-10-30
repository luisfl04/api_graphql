package est.api_graphql.api.data.user;

import org.springframework.data.jpa.repository.JpaRepository;

interface  UserRepository extends JpaRepository<User, Long> {}
