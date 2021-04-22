package com.example.demodao.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey



@Entity(tableName = "User")
data class EntityUser(
    @PrimaryKey(autoGenerate = true) val idUser: Int = 0 ,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "nome") val nome: String,
    @ColumnInfo(name = "cognome") val cognome: String
)

@Entity(
    tableName = "information", foreignKeys = [ForeignKey(
        entity = EntityUser::class,
        parentColumns = arrayOf("idUser"),
        childColumns = arrayOf("idUserInf"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class EntityInformazioni(
    @PrimaryKey(autoGenerate = false) val idUserInf: Int,
    @ColumnInfo(name = "genere") val genere: String,
    @ColumnInfo(name = "luogo") val luogo: String?,
    @ColumnInfo(name = "data") val data: String ,
    @ColumnInfo(name = "indirizzo") val indirizzo: String?
)

@Entity(
    tableName = "note", foreignKeys = [ForeignKey(
        entity = EntityUser::class,
        parentColumns = arrayOf("idUser"),
        childColumns = arrayOf("idUserNote"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class EntityNote(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "idUserNote") val idUserNote: Int,
    @ColumnInfo(name = "titolo") val titolo: String,
    @ColumnInfo(name = "testo") val testo: String

)


@Entity(
    tableName = "modificaNote", foreignKeys = arrayOf(
        ForeignKey(
            entity = EntityNote::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("idMod"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class EntityModificaNote(
    @PrimaryKey(autoGenerate = true) val idMod: Int,
    @ColumnInfo(name = "dataCreazione") val dataCreazione: String,
    @ColumnInfo(name = "dataModifica") val dataModifica: String

)

@Entity(
    tableName = "access", foreignKeys = [ForeignKey(
        entity = EntityUser::class,
        parentColumns = arrayOf("idUser"),
        childColumns = arrayOf("idUserAcc"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class EntityAccesso(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "idUserAcc") val idUserAcc: Int,
    @ColumnInfo(name = "dispositivo") val dispositivo: String,
    @ColumnInfo(name = "iP") val iP: String

)

@Entity(
    tableName = "DataAccesso", foreignKeys = [ForeignKey(
        entity = EntityAccesso::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("idData"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class EntityDataAccesso(
    @PrimaryKey(autoGenerate = true) val idData: Int,
    @ColumnInfo(name = "data") val data: String,
    @ColumnInfo(name = "entrata") val entrata: String
)

