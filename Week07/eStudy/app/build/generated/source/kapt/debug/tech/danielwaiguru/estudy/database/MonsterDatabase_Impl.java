package tech.danielwaiguru.estudy.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MonsterDatabase_Impl extends MonsterDatabase {
  private volatile MonsterDao _monsterDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `monsters` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `imageFile` TEXT NOT NULL, `monsterName` TEXT NOT NULL, `caption` TEXT NOT NULL, `description` TEXT NOT NULL, `price` REAL NOT NULL, `scariness` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5437359e15a3fbe3410ae8ab397c0725')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `monsters`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsMonsters = new HashMap<String, TableInfo.Column>(7);
        _columnsMonsters.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonsters.put("imageFile", new TableInfo.Column("imageFile", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonsters.put("monsterName", new TableInfo.Column("monsterName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonsters.put("caption", new TableInfo.Column("caption", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonsters.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonsters.put("price", new TableInfo.Column("price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMonsters.put("scariness", new TableInfo.Column("scariness", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMonsters = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMonsters = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMonsters = new TableInfo("monsters", _columnsMonsters, _foreignKeysMonsters, _indicesMonsters);
        final TableInfo _existingMonsters = TableInfo.read(_db, "monsters");
        if (! _infoMonsters.equals(_existingMonsters)) {
          return new RoomOpenHelper.ValidationResult(false, "monsters(tech.danielwaiguru.estudy.models.Monster).\n"
                  + " Expected:\n" + _infoMonsters + "\n"
                  + " Found:\n" + _existingMonsters);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "5437359e15a3fbe3410ae8ab397c0725", "da12e13a8f50738b25947e06ee5d483c");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "monsters");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `monsters`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public MonsterDao monsterDao() {
    if (_monsterDao != null) {
      return _monsterDao;
    } else {
      synchronized(this) {
        if(_monsterDao == null) {
          _monsterDao = new MonsterDao_Impl(this);
        }
        return _monsterDao;
      }
    }
  }
}
