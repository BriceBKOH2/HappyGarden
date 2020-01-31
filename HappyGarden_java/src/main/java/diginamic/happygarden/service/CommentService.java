package diginamic.happygarden.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Comment;
import diginamic.happygarden.repository.CommentRepository;

@Transactional
@Service
public class CommentService extends AbstractService<Comment, Long, CommentRepository> {
	
}
