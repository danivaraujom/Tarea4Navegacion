package gal.carba.tarea4navegacion;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView btnNav = findViewById(R.id.bottomNavigationView);
        btnNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.nav_rojo){
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.fragmentContainerView,RojoFragment.class,null).commit();
                } else if (item.getItemId()==R.id.nav_azul) {
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.fragmentContainerView,AzulFragment.class,null).commit();
                } else if (item.getItemId()==R.id.nav_verde) {
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.fragmentContainerView, VerdeFragment.class,null).commit();
                }
                return true;
            }
        });


    }


}