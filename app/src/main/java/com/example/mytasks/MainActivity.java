package com.example.mytasks;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private TasksFragment tasksFragment;
    private AboutFragment aboutFragment;
    private GalleryFragment galleryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasksFragment = new TasksFragment();
        aboutFragment = new AboutFragment();
        galleryFragment = new GalleryFragment();

        // Load default fragment
        loadFragment(tasksFragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_tasks) {
            loadFragment(tasksFragment);
            return true;
        } else if (id == R.id.menu_about) {
            loadFragment(aboutFragment);
            return true;
        } else if (id == R.id.menu_gallery) {
            loadFragment(galleryFragment);
            return true;
        } else if (id == R.id.menu_clear) {
            if (tasksFragment != null) {
                tasksFragment.clearAllTasks();
            }
            loadFragment(tasksFragment);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();
    }
}