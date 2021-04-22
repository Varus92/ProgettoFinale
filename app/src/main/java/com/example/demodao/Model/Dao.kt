package com.example.demodao.Model

import androidx.room.*


@Dao
interface DaoUser {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg user: EntityUser)

    @Delete
    suspend fun deleteUser( users: EntityUser)

    @Query("SELECT email FROM user")
    suspend fun getAllEmail(): List<String>

    @Query("SELECT password FROM user")
    suspend fun getAllPassword(): List<String>


//    @Query("SELECT * FROM user WHERE email = :email")
//    suspend fun checkEmail(email: String): Boolean

//
//    @Query("SELECT * FROM user WHERE email =:email AND password = :password")
//    suspend fun checkPassword(email: String, password: String): Boolean
//
//    @Query("SELECT idUser FROM user WHERE email =:email")
//    suspend fun returnID(email: String): Int

}

@Dao
interface DaoInformazioni {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInformation(vararg information: EntityInformazioni)
//
//    @Query("SELECT * FROM information WHERE idUserInf = :id")
//    suspend fun informationUserInformation(id: Int): List<EntityInformazioni>

    @Update
    suspend fun updateUser(vararg information: EntityInformazioni)

}



@Dao
interface DaoNote {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(vararg notes: EntityNote)

    @Delete
    suspend fun deleteNote(note : EntityNote)

    @Update
    suspend fun updateNotes(vararg notes: EntityNote)
//
//    @Query("DELETE FROM note WHERE idUserNote = :idUser") // cancella tutte le note che si riferiscono a quell utente
//    suspend fun deleteAllNotesforUser(idUser: Int)
//
//    @Query("SELECT * FROM note WHERE idUserNote = :id  ")
//    suspend fun getAllNoteforUser(id: Int): List<EntityNote>

}

@Dao
interface DaoModificaNote {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModificaNote(vararg notes: EntityModificaNote)
/*
    @Query("SELECT dataModifica  FROM modificaNote WHERE idMod = :id  ")
    suspend fun printDate(id: Int): String
*/
}

@Dao
interface DaoAccesso {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccesso(vararg access: EntityAccesso)

}