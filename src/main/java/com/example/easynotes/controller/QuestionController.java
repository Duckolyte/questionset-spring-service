package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Question;
import com.example.easynotes.repository.QuestionRepository;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import repository.QuestionRepository;
//import Question;
//import QuestionNotFoundException;

@RestController
@RequestMapping("/question")
public class QuestionController {

  private static final Logger log = LoggerFactory.getLogger(
      QuestionController.class
  );

  @Autowired
  QuestionRepository questionRepository;

  // Get All questionRepositors
  @GetMapping("/all")
  public List<Question> getAllQuestions() {
      return questionRepository.findAll();
  }

  // Create a new Question
  @PostMapping("/create")
  public Question createQuestion(@Valid @RequestBody Question question) {
      return questionRepository.save(question);
  }

  // Get a Single Question
  @GetMapping("/{id}")
  public Question getQuestionById(@PathVariable(value = "id") Long questionId) {
      return questionRepository.findById(questionId)
              .orElseThrow(
                  () -> new ResourceNotFoundException(
                      "Question",
                      "id",
                      questionId
                  )
              );
  }


  // Update a Question
  @PutMapping("/{id}")
  public Question updateQuestion(
    @PathVariable(value = "id") Long questionId,
    @Valid @RequestBody Question questionDetails
  )
  {

      Question question = questionRepository.findById(questionId)
              .orElseThrow(() -> new ResourceNotFoundException(
                  "Question",
                  "id",
                  questionId
              ));

      question.setCode(questionDetails.getCode());
      question.setLabel(questionDetails.getLabel());
      question.setUsesImage(questionDetails.getUsesImage());

      Question updatedQuestion = questionRepository.save(question);
      return updatedQuestion;
  }



  // Delete a Question
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteQuestion(@PathVariable(value = "id") Long questionId) {
      Question question = questionRepository.findById(questionId)
              .orElseThrow(() -> new ResourceNotFoundException("Question", "id", questionId));

      questionRepository.delete(question);

      return ResponseEntity.ok().build();
  }

}
