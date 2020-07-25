package tech.danielwaiguru.estudy.database;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import tech.danielwaiguru.estudy.models.Monster;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MonsterDao_Impl implements MonsterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Monster> __insertionAdapterOfMonster;

  public MonsterDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMonster = new EntityInsertionAdapter<Monster>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `monsters` (`id`,`imageFile`,`monsterName`,`caption`,`description`,`price`,`scariness`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Monster value) {
        stmt.bindLong(1, value.getId());
        if (value.getImageFile() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getImageFile());
        }
        if (value.getMonsterName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMonsterName());
        }
        if (value.getCaption() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCaption());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDescription());
        }
        stmt.bindDouble(6, value.getPrice());
        stmt.bindLong(7, value.getScariness());
      }
    };
  }

  @Override
  public Object insertMonster(final List<Monster> monster, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMonster.insert(monster);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object getAllMonsters(final Continuation<? super List<Monster>> p0) {
    final String _sql = "SELECT * FROM monsters";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<Monster>>() {
      @Override
      public List<Monster> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImageFile = CursorUtil.getColumnIndexOrThrow(_cursor, "imageFile");
          final int _cursorIndexOfMonsterName = CursorUtil.getColumnIndexOrThrow(_cursor, "monsterName");
          final int _cursorIndexOfCaption = CursorUtil.getColumnIndexOrThrow(_cursor, "caption");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfScariness = CursorUtil.getColumnIndexOrThrow(_cursor, "scariness");
          final List<Monster> _result = new ArrayList<Monster>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Monster _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpImageFile;
            _tmpImageFile = _cursor.getString(_cursorIndexOfImageFile);
            final String _tmpMonsterName;
            _tmpMonsterName = _cursor.getString(_cursorIndexOfMonsterName);
            final String _tmpCaption;
            _tmpCaption = _cursor.getString(_cursorIndexOfCaption);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            final int _tmpScariness;
            _tmpScariness = _cursor.getInt(_cursorIndexOfScariness);
            _item = new Monster(_tmpId,_tmpImageFile,_tmpMonsterName,_tmpCaption,_tmpDescription,_tmpPrice,_tmpScariness);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }
}
