package com.portfolio.api.service;

import com.portfolio.api.dto.MessageDto;
import com.portfolio.api.entity.Message;
import com.portfolio.api.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MessageService implements IService<Message, MessageDto> {

    @Autowired
    MessageRepository messageRepository;


    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message add(MessageDto entity) {
        Message message = new Message();
        
        message.setEmail(entity.getEmail());
        message.setName(entity.getName());
        message.setText_message(entity.getText_message());
        
        return messageRepository.save(message);
    }

    @Override
    public Message update(Integer id, MessageDto entity) throws NotFoundException {
        
        Message message = this.findById(id);

        message.setEmail(entity.getEmail());
        message.setName(entity.getName());
        message.setText_message(entity.getText_message());
        
        
        return messageRepository.save(message);
    }

    @Override
    public Message delete(Integer id) throws NotFoundException {
        Message message = this.findById(id);
        messageRepository.deleteById(id);
        return message;
    }

    @Override
    public Message findById(Integer id) throws NotFoundException {
        Optional<Message> message = messageRepository.findById(id);
        if (!message.isPresent()) {
            throw new NotFoundException();
        }
        return message.get();
    }

}
