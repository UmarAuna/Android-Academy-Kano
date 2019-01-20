#Agenda
 - Android Developments tips faster dev.
 - Imposter Syndrome
 - Views 
 - 

# List View

What is a listview?
What is an adapter?

Implementation
--------------

**activiy_main.xml**

```

<ListView
  android:id="@+id/list"
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  android:layout_alignParentTop="true"
  android:layout_alignParentLeft="true"
  android:layout_alignParentStart="true"
  android:clickable="true"/>
```
**MainActivity.java**

```
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.security.SecurityPermission;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[]auna={"umar","saidu","Auna"};
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,auna));
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(MainActivity.this, "welcome", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

```


# Spinner

What is a Spinner?
What is an adapter?

Implementation
--------------

**activiy_main.xml**

```

<Spinner
  android:id="@+id/list"
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  android:layout_alignParentTop="true"
  android:layout_alignParentLeft="true"
  android:layout_alignParentStart="true"
  android:clickable="true"/>
```

**MainActivity.java**

```
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.security.SecurityPermission;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[]auna={"umar","saidu","Auna"};
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,auna));
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(MainActivity.this, "welcome", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

```



# RecyclerView

What is a RecyclerView?
What is a Viewholder?
What is an onBindViewHolder?

**build.gradle**

```
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    //..
 
    // RecyclerView
    implementation 'androidx.recyclerview:recyclerview:1.0.0'
}
```

**activity_main.xml**

```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:showIn="@layout/activity_main"
    tools:context=".MainActivity">
 
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recycler_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:scrollbars="vertical" />

</RelativeLayout>
```

**Writing the Adapter Class**
**Movie.java**

```
public class Movie {
    private String title, genre, year;
 
    public Movie() {
    }
 
    public Movie(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String name) {
        this.title = name;
    }
 
    public String getYear() {
        return year;
    }
 
    public void setYear(String year) {
        this.year = year;
    }
 
    public String getGenre() {
        return genre;
    }
 
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
```
 **movie_list_row.xml**

 ```
 <?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="?android:attr/selectableItemBackground"
    android:clickable="true"
    android:focusable="true"
    android:orientation="vertical"
    android:paddingBottom="@dimen/row_padding_vertical"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/row_padding_vertical">
 
    <TextView
        android:id="@+id/title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:textColor="@color/title"
        android:textSize="16dp"
        android:textStyle="bold" />
 
    <TextView
        android:id="@+id/genre"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/title" />
 
    <TextView
        android:id="@+id/year"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentRight="true"
        android:textColor="@color/year" />
 
</RelativeLayout>
 ```
**MoviesAdapter.java**

```
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
 
    private List<Movie> moviesList;
 
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
 
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }
 
 
    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);
 
        return new MyViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }
 
    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
```

**MainActivity.java**

```
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
 
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
 
        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
 
        prepareMovieData();
    }
 
    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);
 
        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);
 
        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);
 
        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);
 
        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);
 
        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);
 
        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);
 
        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);
 
        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);
 
        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);
 
        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);
 
        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);
 
        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);
 
        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);
 
        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);
 
        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);
 
        mAdapter.notifyDataSetChanged();
    }
}

```
