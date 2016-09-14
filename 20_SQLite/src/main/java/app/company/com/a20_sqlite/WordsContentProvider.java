package app.company.com.a20_sqlite;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class WordsContentProvider extends ContentProvider {

    private static final int MULTIPLE_WORDS = 1;
    private static final int SINGLE_WORD = 2;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private WordsDBHelper words_db_helper;

    static {
        uriMatcher.addURI(Words.AUTHORITY, Words.Word.PATH_SINGLE, SINGLE_WORD);
        uriMatcher.addURI(Words.AUTHORITY, Words.Word.PATH_MULTIPLE, MULTIPLE_WORDS);
    }

    public WordsContentProvider() {
        words_db_helper = new WordsDBHelper(this.getContext());

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;
        SQLiteDatabase db = words_db_helper.getReadableDatabase();
        switch (uriMatcher.match(uri)){
            case MULTIPLE_WORDS:
                count = db.delete(Words.Word.TABLE_NAME,selection,selectionArgs);
                break;
            case SINGLE_WORD:
                String whereClause = Words.Word._ID+"="+uri.getPathSegments().get(1);
                count = db.delete(Words.Word.TABLE_NAME,whereClause,selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknow uri"+uri);
        }

        getContext().getContentResolver().notifyChange(uri,null);
        return count;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case MULTIPLE_WORDS:
                return Words.Word.MINE_TYPE_MULTIPLE;
            case SINGLE_WORD:
                return Words.Word.MINE_TYPE_SINGLE;
            default:
                throw new IllegalArgumentException("Unknow Uri:" + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = words_db_helper.getWritableDatabase();
        long id = db.insert(Words.Word.TABLE_NAME, null, values);
        if (id > 0) {
            Uri newUri = ContentUris.withAppendedId(Words.Word.CONTENT_URI, id);
            getContext().getContentResolver().notifyChange(newUri, null);
            return newUri;
        }
        throw new SQLException("Failed to insert row into"+uri);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return 1;
    }
}
