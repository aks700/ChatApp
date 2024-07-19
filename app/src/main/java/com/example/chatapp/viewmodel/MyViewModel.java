package com.example.chatapp.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.chatapp.R;
import com.example.chatapp.model.ChatGroup;
import com.example.chatapp.model.ChatMessage;
import com.example.chatapp.repository.Repository;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    Repository repository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository();
    }

    //Auth
    public void signUPAnonymousUser()
    {
        Context c=this.getApplication();
        repository.firebaseAnonymousAuth(c);
    }

    public String getCurrentUserID()
    {
        return repository.getCurrentUSerID();
    }

    public void SignOUT()
    {
        repository.signOUT();
    }

    //Getting chat groups
    public MutableLiveData<List<ChatGroup>> getGroupList()
    {
        return repository.getChatGroupMutableLiveData();
    }

    public void createNewChatGroup(String groupName)
    {
        repository.createNewChatGroup(groupName);
    }

    //Messages
    public MutableLiveData<List<ChatMessage>> getMessagesLivData(String groupName)
    {
        return repository.getMessageLiveData(groupName);
    }

    public void sendMessage(String msg,String chatGroup)
    {
       repository.sendMessage(msg,chatGroup);
    }
}
