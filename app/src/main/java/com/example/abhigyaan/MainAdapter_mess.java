package com.example.abhigyaan;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter_mess extends FirebaseRecyclerAdapter<MainModel_disha, MainAdapter_mess.myViewHolder> {
    private boolean toastShown = false;

    public MainAdapter_mess(@NonNull FirebaseRecyclerOptions<MainModel_disha> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModel_disha model) {
        holder.name.setText(model.getName());
        holder.clas.setText(model.getClas());
        holder.update.setText(model.getUpdate());
        Glide.with(holder.profile_image.getContext())
                .load(model.getSurl())
                .placeholder(R.drawable.ic_launcher_background)
                .circleCrop()
//                .error("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5OjcBCgoKDQwNGg8PGjclHyU3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3N//AABEIALkAxgMBIgACEQEDEQH/xAAcAAABBQEBAQAAAAAAAAAAAAABAAIFBgcEAwj/xABDEAABAwMCAwUGAQkGBgMAAAABAAIDBAURBiESMUEHEyJRgRRhcZGhsTIVIzNCUoLB4fAkNTZDYrI0VHKi0eJzksL/xAAbAQACAwEBAQAAAAAAAAAAAAABBAAFBgMCB//EAC0RAAICAgEDAwMCBwEAAAAAAAABAgMEEQUSITETI0EGIlEzsTI0QmFxgaEU/9oADAMBAAIRAxEAPwC6lJIoL5WaYBSRKCIRJJIFQgikkkoQSSSShBJBJJQgkic890CoHUmpYLNDwMHfVbh4I87D3k/wXaimd0uiC7glJRW2S1dX0lvgMtbOyFg6vP281X26+sT5u7jnkI5F/BsPTn9FlN9uldeq5xrJ3SkHZucD4AKPgkjiLmiMtJ55PJaijgK1Ddr2yvnmvfZdj6EorpR1bGvhqInggcnbjPmOa7xjod/isEpqssDO6dIc+f8AJTFDqi5217SyZ4aD+jkflrvdvuErf9Py81yPccxPybKE4KMsV1ju9DHUMHC4jxNPMH4KTCzltcq5OMl3Q1tNbQ8JwTQnBcGeWFOCaE5eWeAhJIJIAOEoFIoJgaEgUikiQSSSBUCFApJKEEEUElCBSQSRINc7Az9+Sxm/3E196mle/c5wXcgOmPT+K2Cuc5lHO5mOIROIz54OFg7gHTSFxAJIHLr8fmtJwFSfXP8A0I5stJI7KO3STOc+BpcGNHjxyPkuaqgHe8FVHh4/EHNOR6rWtF2empdPRtkbl04z6dN163nSFNdA2Zw4ZWjDXhoDj8Vold9wr6O0Y+x0UP4WucW8nYwce9PNR347oYMLstOd8H+irvctAyQUzpGykkDOcKlwW4UVxfE8+AlpwR1ByD9CPVdIzUjnKtxLr2b3ZnExj3sHekQnHR4Hh+eFpg5rGdNxCKuq4YskicluPJrgRj1OFszfPKyX1BUo2xn+R3GluOh6cE0JwWbYwxwRQCK8s8BCSQSQAcBTSi7kgmRoSBRJQJRQRJFBJQgkkigoQKQQCKhApIBFQh41MQnp5YT/AJjC35hZNWWB1JqCjg4HPpqiQcDnbF4Di0jmev0wtfHMKPntcU88M8jTx0zwYd9mgbEY6c1oOEtcetC2RBTSOXUFZUUMcLKIyjbhbHBEHEeW52AUPYtU3asqREWGSJzsBz4g0jffcEg8wryyFj6cOccBwXPBS07XnuwHY3JJ2/rOFewn9utHDp7+SD1ZqGSzhkDoWSvkbkhzsNwPeovTL7fqasNLWWunD2A8L4JQXRnkPerRd7fFVvbJKxg4XGPJAcNxtn6r103YaW31QMEUTeDdrmNLeAE7gDpncrrFx7Jnie9diiadhbPqSFrYh4AXvPljC0gAABQGmqEU8tTUx/o6nxuBZgh/E4Y+HCG/MnqrAFkubv8AUyOleEMUQ6Y9xycE0JwVGz2OCKARXlnhhCKARQIRhSSSKaGxFApFBQgkkigiEJQSKChBwSym5SBUIOTkzKcCoAI+GUJGB7d8nh3AyijyBXbHnKNi6WeZHLK97mF/fcLW81z1ElPUQRiWlrSAeIBsEnTrsN0TJHDUjvP0bjt8V01xl4OPv3hnQN5ra1+BVvuQDe4iknf7dUta5vC6Odr2NJzkYDgOoCsun63vKKol8bg4NDXDmRyyPhzXhRwTTW6dnfd5HUsIPH0XVSQ+zQthHIb8lwzcmONX6nz8HnSm9I9gxkfgj3a3kU5NTgsTbZKyblL5GNaQ4JwTQiuIB6KaEUGeGPCSaivICNTUSUCmhsSCSGd0QhKCRQKJAlBAlDKIUOyllNyoXVV5lsdtinjia90zy2Nz9m5AySfmu+PjzyJqEF3Odlka1uXgnAnA+WFCdk97GojdYLsGyTwujkiIHCGsOQQMdAW/VdGvv7JcIqWnJZD3IcQCd3ZI+wCvqfpq+yenJFdZylcI70ds1bTUzT307Bj9Ubn5JlLc6aujY+keXh2+S0jHRUofodvI9VabPTiKhpzHzDcFPZH09TiKMuptnHE5CeRKXbSR0yxsfMWPGQehVWvbaxlSyKkqZGs4scJOQFaKl3CQ89FD1AdNVDh5lMRGmSFifM2SOmdK6RgwTnorDKcyOJ/aKgKLhpHggb/xXD+XqqnvMolbxU8/5yNrt8dCAenL6pHOwLc6KjW+6/6eXbGpdUvBbBuiuGiuVNV5ZFJiQfqu54PLH1XaCeRBHxWSyca3Hm4Wx0xmuyNkeqD7Dk5NTglmemOCKanBA8Dkk0JIEI5BJApoaEgkUFCBJTSkUCiFCKGUcphOxRSCeVXUx0tLNUTODY4mF7iegAyuzX9ngv2kGUdCQZ6Ytmpi7bjcG7gn3hx9cKB1Xb6yv0tcZaSRjGU7RLMHkjijb4nAHzwFUuy3VkoqmafuEz5GVErRSv5mNx5t+Hl5brYcFjdFTtfl/sUnIW9U+hEb2V3U2zW9GDkR1PFTPHx/D/3Nb81pfaNg3aAt5ezj/cVh9QJrRe5Wt2mo6o8Of2mP2+y0+6aoptU1801E0inpmsja92xeSMk48ug+C1GO/cKfI/TZzM/AVL6L1FDc4Z6F3CyspXlroj+s0HAcPMfY+7CiGcn7gb81UL/U2xlwE1s9soLrAcPczHdyOA/ECDxNJ67H7k++RrU4I8cda4TZslbwGPgcMEkc06KiYzMgxkBZVQ9o9zgjEd0pY6xrR+MHu3+pAIPyCnIe1C192RLbqwHya5jvrkKidE14RfLIra8l4ZTt4skDbdQurKVjIqeoBa0tkLd+vEq6e0d83gs1kqqmXOBxEnHo3JPzVX1NWajZdbfUamZNThxZNDC4cLWt4sHDfPzz4uWV3xqpRsUmcMi6Mq3FfJc46hzS17fxNO3wP81dtNS194jqXugb3cPCGSh36XIORjzGPqFn/eYGSeg9VbNE6gpbG2vdcphDSNg75zj0LSAAPMni2CseU46jMq9xd/yU+Fkzps0mWIgseWuBaRzaRjCcCqVZdb1WodTyuqWiGlmHBTwczHjcZP7Xn/JXJvIeWF8x5HAeHb0N7Xwaii1Wx2eoRCa1FVrOg5JAIIEI9BJNKZGRFJApIhQCkkU0okEUwn3okr1t9OKytjhd+AnL98bDcrvRW7LFBfJ5nJRi2yu2jtHt8F6qbJXQhtMZ+6jqmnLXO/CQ8eWc4PLHzXnBo6kp9cWy62+KOJsdRIKmAbDIY4tc0dDnGR8PeoXVnZg6Kokn09Ud43PEaWd/i+DX8j6+pUPZ9V3Wljqra8VMl1hnEsHeAuc7uzl7HZ3/AAtP2+P0WmtVVqEfCM1ZNzk5P5F2uUENHq174HtPtMLJXtB3jdjhPzwD6lcuhctFwbwnhPdHPT9ZQV9uVReL5W1svG0zScbWSjdreQHoAB6Kb0VcJ++ltoePZhGZgzhbvJ4RnOM8tkzQ/cQvet1stLCAXZ8guGXs4uF9ldc6KtpGsmOeCXiBBHhP2XWw/nMdOS94e0OLTTxbZ6CWYBvG2SN43ySeRH8U5lacBPFWplYuXZrqalqu7hpo6wYzxU0w29HELyi0Bq9xw2y1GCM7yxgbe8uWjW3tb09JUd7Uw11KOHHijDv9pJ+i6Wdpmlo6jwXCrdEScNFNJ4fmFXaLExeT8s6cuT4ZHVdvqW82hxYT8jhw+a8rxe7nd44o7lWy1YiLnsdKeItLueCd8HA25bL6H09W2LUzaiWI01dC0khksQJafe1wyPkuS/aK03ea3FTQRwuY3AfTHuneoGM+oUSAZ5Ry95SQv/aY130XBqd+bQ/l4XtO45b4/iux8BtgdRPOTTExF3nwkjPrhCm/J9VUNF5cW29gMkxBP4W+LG2++Mbb7q2k/aKyC1aWnss0Y5s8F1vLm7Na+np2+Z3Befd5K5FoZI5v7JIWXXrtSkDJINNwCJnBwNqZm+IE7EtbyHuJ9+y0a1TPqbdSTyuLpJYWPeTzJLQT91gfqaC6ISNJx77tHc0pwTAnBY1+SxYUkkkAEYUCkUk0NISBSKWUUQWU0oppRCNdnBwMqla9vNytVTbn26pkpXAOlbKw4LjyI9/PkfNXOV4ZG57jgNGSfL3qG1BqCw3LTdCLnTVENvewSRiSJglc48y1p3I97eav+Cx/Uu9R+I/uIchZ019P5IKy9qMb8Q6gpA0/8zTt2z/qZ/4Pou/XMtvkjp71axSPrmtbPFM0DMzAMOyeZGD19yz6rs8V0uPs+k6G5VbMZfiLiLPiMnA+JCiKm3VFvlxNJ3Um7C1pyfIg/wBYWx2UZdezqkg1JdbmdQQw1UkEADGOaG83bkAY5cvVaBbtNWS3OL7fbKZspHN4Lj8MnJCyOjsjq2WgZYJZWVL4waljstMLhs53EP1Sd/ctqY+NtK09y9zcHLmtJJI58t0pfNrSi+45iwT25LsNcyungMU1NSNpyCHRseclvu25qix2iwX2auinhqpauGUxMnhLh4RyJz4djnOVb5XUbGd7JLXRDiGA7jAB/eGFmlJ2heyV9XI62MkZUScTyyThz0zyx0UpcnFrZ6vUISUtHrP2YX1h4qaehnYT4SJi0ke8FuMrxb2a6pE3AaanBIyD7Q1Wmh7U7I1rO9o66LHQMa4ff+ClW9qem3zNe51YNuXs+6a0hEyS92C62CtdFcaV8L2tB4x4mEHycNvqmW/Ud4tUubdc6iNv7HHxNP7pyFtEfaPZalznUNdHHloa/wBqBj+GCdivSutNkv1EKuS20tcXDDnRcIec9Q5pCKiFLZmJutRc2Cuq3NdUT5c8tGATnoEKOgq7zI+30XB39Qwtbxuw33k+mV43ptJTXGWntsT20kTuHupHHLT13+OV62C/UWnrg+rqmySzshLYmQ9XHzcTtsrGUtVCUYe4XfR3ZTQRmR9/eK1zeTInOZG09dxgu/lyV6qKeKknfTU7QyKLwMZ+yBsAseHaZqCYhlO+Cig3IEUYLse9zs5O3TC1GzzvqbXSzyyF8kkTXPcTu5xG5WL+pdehDX5LzA/jZIs5IpjeSeCsQyyYQUkEkAaI0oFIpFMjIk1HKavSCFBJNJUIeNXn2eXhbxHgdgee3JZPV0kkVqttVcHvkq7nxSukeeJzIweFjR7j4j/9fJa4cdVVNZ2eS7UzWwRmGShaPZjjwlmBlvuOwK0fBZEK3KuT034K3kapSipR+Cxazq4dF6HZQ2VgppJhjibza3YOeT1ecgZ95P6qwp8vf1rXAeBoHCFr9wqY9daNqYoHMNWyON2M7xyjm31LceoWO17DRzCN0L4ZmZDo3twVq97KfTRpvZnCH0lfUY/OGQR8fkAM4+bipq43yot8oiiaCA3IBcso09crt35prU9wdLzZ+q4jqfRdeop7pRsiM1S8h+wPBjixz3wlZVbnsdhdGEC/w194v9JLT1ZjggqGmPhjdxO4D13G2ygJ+y6N+9Nc5I+vDLEHfYj7Kp23Vl7oJnSQVbXZwC18bSMe7y9FY6PtSrmDFXbaeY+ccjo/vlMRiorQtOfWwHsqvTnZpqqhkA5cTnNP+0pg7MdTeLhjo3Y/ZqP/ACFYqDtXt4aParVVsdj/AC3tf9+FSkXanYHRHjir43E8nRNP2cumkcyjR9m+piTG6mgxJt/xDcA9CoCfTuoLY57ZrZWxgeFwawuHlgluy1Z3abp0Eb1g6/oP/ZeknaLpurf37pamDi8JMkJ3d15cX8EUl+Q6RUNIaKluFvMlZUMozxnwPZ4sHcc/P+Kk4+yz2+uMkl0DafiLOGODxAA45k43XXd629R0VZcrTPNGalofFHDDmQ5w1u2M8sFU+TtG1FFTMginipp43EvlEeXk75zxZGcnyXv1N9n4JKEYs063aA0zRTBnsZqnMAa51RI5zXHr4fw/RWiship6l8MEbY4mBoaxjcBowNgF8+Q3zUtykBjuVykJOD3M7mNyf+nAC2XSFJdzYKOGS31MlS1p7x03gAOTzc477Y3AKo+cxbcmiMa477jmJJQl1PwTQ25JwK6YtP3V2Hz1lHCR/ksidJn4uJH0AXGxzhNPBK0NlgkMbwDkcgQRt1BCymXxORi1epPQ/C+ub1FnokhlJVJ2I3KRKBQTIwFNJSSKJAEppTimlEIiUDukgV6i9PaI1tEAzT/5MiqZNOuZTTzSske2YF7HNAcOHA3wS7OB1AVO1ZpOtbI+6XK4RzSSOOWxMIDcAnAzyGy1DPmvegt1Fd5JqWuaJI2wOJYT0cCw/QlX/HcjkWXRqk9orsvGqjW5JaZj+hCykoqu7VpLaeBpiiA6k7uPvIGB+8tU0/X2S90ApaGopKpvCOKOTzPPLSM8/NQh0dbayyQWiKd5gDz3UgfhwwScuHLLsk756LO75oy92asmdDR1U9PFJ4KiBpdt0Jxu0458lqo9mUzkarX9m1prHmQ2yngz/wAvMWZ+ABwoafsfoJSfZaysp39BIGvA+gKz63av1BbvDBeKxgacFr394Bjph+cK1W7tbv8ATge0xUFWAOboixx9WnH0XrseTqk7G6+Np7i7Usg6ccTmfYlRNR2W6gY8hs1vc3zEzx/+VY4+2eJw/ttkc3zMFQHD6gK3094/KdBSVcbDEytg71jXHdo/og+i8TmoLZ1qr63ozSj7L7jLllbcKSEYz+b4pXfYfdKfs4ZT1jqAXgEObxcAg7xxPMY4STnpy69Vpbi5zoKgAu4XFsjTv4XbH5HB+GV2m4stUuS5lO+U/pNvFsNj8lyjkJv7l2HP/OkuyK6NLalurKQUzvyc2Nje8knaAXYaAcNOSPUK02vRr6aAR3K8VNSQNw1rGA+obn5YXnXa0MFuqZqSlbcZoG8Rjhk4Mjqev03Wf03aTqLUtRLT2ruKXDSWMgaDI/3Dizk8/LltvsmKppx+3wcXXL50jX6e3Wizs76Knp6cNGXTSEZ9XO3UZX69sVGMR1JqpOjaZpeD+9+H6rKqWOe9wievqqmeo70NPG/j4Wu2Dm58ncIx7/cVbtOWY2q3xx1jmVFYcuknDQM5OwHlgY9cpHkc+OHX1tbZ1px67JabbO6fWN/uO1ptTaWM/wCbUbn+A+694H1U0r6iu7nv5GtD+5yA4jPiIPXGB6BPB26+qcCshm8zflRdbSSY/DHrh4Q7KSblJUukdtEeUE0pJk7jkk1AqEHlN6ppSRIJJAoYz8UUggdsq3erhPp7Ubq+pdI2kqKSKjEYH6Vz3cbse5rcZP8AqAVppqWSsl4A7hbjL3/shZx2sVVxp9W0VfVMDqQw/wBkjd0buDkftbg/LywtLwOP9zta/wAFVyVvZQXkrTL5d7TeZLnFK+GoqJDOWO/BI3J2I8uY92FqOke0S2XScCt4aCpc3D2Sv/Nv97XfwP1UhaqHTWrLAKQCCojLGhjm4D4HAefNp3P88qi3rsnu1L3jrVNHWsb/AJTzwSj0/C75j4LT6aKc0+5WHTt5b3lfbaWZzh+lGA70cN/kqldezTTTv+GmqaL3NnDx/wBwJ+qzL2fUWnJHFjLjb3NOXOaHNZ8xsUJdZ6heMPu0jun4W/fChCy3DQVrp5A2K51c7jsGtibv6q56Xgmp7TDSVDJsUxxDLLjdo2xttsMj0WMSXm6SuL33Opz7piPsV32Kn1BX1rJrY6oc/dole84wefPmFynDrWjtVYoPsbXV6jttDFLiRrng7Bu+6p151g+4fmpqZhgyGlvUjPvXhfLE+yWaGsqpnS1ZGalkY8AJ32zvttv1+ihZ6bu4GVZOIX7h3mk5VTj8FhC2Eu+yep21EFrq7naXGCONhy2V+Sc7bfDoOpwOqoumfaqPVtE2hIdMyqYG53B8Q5rquOoJZIvYaCN2HEZLm44j02+vxAK7NBUDo75DLE+Ke4A/mY2kPbCOsr3DY4B2GTkkZwmIe1W5S7CV0vVn0o1bTkUlNV3t72tbEa4ilBG7HB2X4PlswfFS55DfPxXmwcIwOWSc+ZJyT8yT6p4WG5PNeXd1f0rwW+PQqof3HjkkgCjlVjO4UEgUkCEakgUkydQpZQS6KECmlFNRCHKGT0SSRRAXq/02n7PR1DmF4kqY21ADc8LA4cZ9/hyAPeFz6w0nT65pm17KkxOaOKknb4mlhxzHUHnlQuvv8M1vwj/3hWPsp/wDQf8AVJ/vK3XFT68ddjO5q6bDHbtS3TSFyZTmo9nq2MDmTQPOHDzB5kbfyU5Z+1q+UfC24wwXBo5OcO7kH7zRj6LSNXf3NL6/wXz5J+J3xVj4FDb7f2uabrwBdKSopHn8TnR94D6tOfou8ag7PnsNRFPbXPPWThDvk4Ar58PNNd+t/XUKbIbDqHW9nLTS2uajiadjIxoOB7tiqNftTBkAobHUOZEN5alhLXSu8h1DR79yubQ3+JKX1+y15/6Uf15oMhg3ttY84NXM4E7gyHB+qnLdquSCiFBUUMc8f4RwvLXfPda1X/onfBYRL/ej/wD5j90All0Xp+4at1AGwtBpeMh8tT42xjoP9R932W0xWKj0+80lFBDHgN7x8cYZxuxz9eeOmVBdiH92UXxf9yrlqD+9pv3fsFT83/KMdwP1kcAKcCmhELDF2EFEFNCRQAPykmhJQh//2Q==")
                .error("https://media.istockphoto.com/id/941782244/photo/portrait-of-a-young-school-boy-smiling.webp?b=1&s=612x612&w=0&k=20&c=nIlhRzsR0vnpyYKWVDp7wny0x9UFFiDy_M-x5wgxoJQ=")
                .into(holder.profile_image);

        holder.btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.profile_image.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true, 1200)
                        .create();
                View view = dialogPlus.getHolderView();

                EditText name = view.findViewById(R.id.textname);
                EditText clas = view.findViewById(R.id.textclass);
                EditText update = view.findViewById(R.id.textupdate);
                EditText image = view.findViewById(R.id.imageurl);
                Button btnupdate = view.findViewById(R.id.updatedone);
                name.setText(model.getName());
                clas.setText(model.getClas());
                update.setText(model.getUpdate());
                image.setText(model.getSurl());
                dialogPlus.show();

                btnupdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(holder.profile_image.getContext());
                        builder.setTitle("Please ensure all updates are accurate and complete");
                        builder.setMessage("Your activity can be tracked through your account");
                        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Map<String, Object> map = new HashMap<>();
                                map.put("name", name.getText().toString());
                                map.put("clas", clas.getText().toString());
                                map.put("update", update.getText().toString());
                                map.put("surl", image.getText().toString());



                                FirebaseDatabase.getInstance().getReference().child("UPdations_mess")
                                        .child(getRef(position).getKey()).updateChildren(map)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Toast.makeText(holder.name.getContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                                                toastShown=true;
                                                dialogPlus.dismiss();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(holder.name.getContext(), "Error while updating data", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.show();
                    }
                });
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new myViewHolder(view);
    }

    static class myViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profile_image;
        Button btnedit;
        TextView name, clas, update;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            profile_image = itemView.findViewById(R.id.img1);
            name = itemView.findViewById(R.id.nametxt);
            clas = itemView.findViewById(R.id.classtext);
            update = itemView.findViewById(R.id.updatetext);
            btnedit = itemView.findViewById(R.id.updatebtn);
        }
    }
}
