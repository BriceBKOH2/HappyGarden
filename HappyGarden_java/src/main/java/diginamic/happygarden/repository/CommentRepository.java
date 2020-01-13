package diginamic.happygarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import diginamic.happygarden.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
}
