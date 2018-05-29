package cl.magnet.mobileappsexample.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Form.class,
        parentColumns = "uid",
        childColumns = "questionId",
        onDelete = CASCADE))

public class Answer {
    @PrimaryKey
    private int uid;

    @NonNull
    private int questionId;

    @ColumnInfo(name = "text")
    private String text;

    public Answer(int uid,int questionId, String text) {
        this.uid = uid;
        this.questionId = questionId;
        this.text = text;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
