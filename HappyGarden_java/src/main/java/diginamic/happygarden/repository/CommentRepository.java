package diginamic.happygarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
}
