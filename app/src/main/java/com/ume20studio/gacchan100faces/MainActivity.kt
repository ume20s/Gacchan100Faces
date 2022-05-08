package com.ume20studio.gacchan100faces

import android.media.AudioAttributes
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import androidx.annotation.RequiresApi
import java.time.LocalTime
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // がっちゃんの写真リソース配列
    val g = arrayOf(R.drawable.akira, R.drawable.g001, R.drawable.g002, R.drawable.g003, R.drawable.g004, R.drawable.g005, R.drawable.g006, R.drawable.g007, R.drawable.g008, R.drawable.g009,
        R.drawable.g010, R.drawable.g011, R.drawable.g012, R.drawable.g013, R.drawable.g014, R.drawable.g015, R.drawable.g016, R.drawable.g017, R.drawable.g018, R.drawable.g019,
        R.drawable.g020, R.drawable.g021, R.drawable.g022, R.drawable.g023, R.drawable.g024, R.drawable.g025, R.drawable.g026, R.drawable.g027, R.drawable.g028, R.drawable.g029,
        R.drawable.g030, R.drawable.g031, R.drawable.g032, R.drawable.g033, R.drawable.g034, R.drawable.g035, R.drawable.g036, R.drawable.g037, R.drawable.g038, R.drawable.g039,
        R.drawable.g040, R.drawable.g041, R.drawable.g042, R.drawable.g043, R.drawable.g044, R.drawable.g045, R.drawable.g046, R.drawable.g047, R.drawable.g048, R.drawable.g049,
        R.drawable.g050, R.drawable.g051, R.drawable.g052, R.drawable.g053, R.drawable.g054, R.drawable.g055, R.drawable.g056, R.drawable.g057, R.drawable.g058, R.drawable.g059,
        R.drawable.g060, R.drawable.g061, R.drawable.g062, R.drawable.g063, R.drawable.g064, R.drawable.g065, R.drawable.g066, R.drawable.g067, R.drawable.g068, R.drawable.g069,
        R.drawable.g070, R.drawable.g071, R.drawable.g072, R.drawable.g073, R.drawable.g074, R.drawable.g075, R.drawable.g076, R.drawable.g077, R.drawable.g078, R.drawable.g079,
        R.drawable.g080, R.drawable.g081, R.drawable.g082, R.drawable.g083, R.drawable.g084, R.drawable.g085, R.drawable.g086, R.drawable.g087, R.drawable.g088, R.drawable.g089,
        R.drawable.g090, R.drawable.g091, R.drawable.g092, R.drawable.g093, R.drawable.g094, R.drawable.g095, R.drawable.g096, R.drawable.g097, R.drawable.g098, R.drawable.g099,
        R.drawable.g100, R.drawable.g101, R.drawable.g102, R.drawable.g103, R.drawable.g104, R.drawable.g105, R.drawable.g106, R.drawable.g107, R.drawable.g108, R.drawable.g109,
        R.drawable.g110, R.drawable.g111, R.drawable.g112, R.drawable.g113, R.drawable.g114, R.drawable.g115, R.drawable.g116, R.drawable.g117, R.drawable.g118, R.drawable.g119,
        R.drawable.g120, R.drawable.g121, R.drawable.g122, R.drawable.g123, R.drawable.g124, R.drawable.g125, R.drawable.g126, R.drawable.g127, R.drawable.g128, R.drawable.g129,
        R.drawable.g130, R.drawable.g131, R.drawable.g132, R.drawable.g133, R.drawable.g134, R.drawable.g135, R.drawable.g136, R.drawable.g137, R.drawable.g138, R.drawable.g139,
        R.drawable.g140, R.drawable.g141, R.drawable.g142, R.drawable.g143, R.drawable.g144, R.drawable.g145, R.drawable.g146, R.drawable.g147, R.drawable.g148, R.drawable.g149,
        R.drawable.g150, R.drawable.g151, R.drawable.g152, R.drawable.g153, R.drawable.g154, R.drawable.g155, R.drawable.g156, R.drawable.g157, R.drawable.g158, R.drawable.g159,
        R.drawable.g160, R.drawable.g161, R.drawable.g162, R.drawable.g163, R.drawable.g164, R.drawable.g165, R.drawable.g166, R.drawable.g167, R.drawable.g168, R.drawable.g169,
        R.drawable.g170, R.drawable.g171, R.drawable.g172, R.drawable.g173, R.drawable.g174, R.drawable.g175, R.drawable.g176, R.drawable.g177, R.drawable.g178, R.drawable.g179,
        R.drawable.g180, R.drawable.g181, R.drawable.g182, R.drawable.g183, R.drawable.g184, R.drawable.g185, R.drawable.g186, R.drawable.g187, R.drawable.g188, R.drawable.g189,
        R.drawable.g190, R.drawable.g191, R.drawable.g192, R.drawable.g193, R.drawable.g194, R.drawable.g195, R.drawable.g196, R.drawable.g197, R.drawable.g198, R.drawable.g199,
        R.drawable.g200, R.drawable.g201, R.drawable.g202, R.drawable.g203, R.drawable.g204, R.drawable.g205, R.drawable.g206, R.drawable.g207, R.drawable.g208, R.drawable.g209,
        R.drawable.g210, R.drawable.g211, R.drawable.g212, R.drawable.g213, R.drawable.g214, R.drawable.g215, R.drawable.g216, R.drawable.g217, R.drawable.g218, R.drawable.g219,
        R.drawable.g220, R.drawable.g221, R.drawable.g222, R.drawable.g223, R.drawable.g224, R.drawable.g225, R.drawable.g226, R.drawable.g227, R.drawable.g228, R.drawable.g229,
        R.drawable.g230, R.drawable.g231, R.drawable.g232, R.drawable.g233, R.drawable.g234, R.drawable.g235, R.drawable.g236, R.drawable.g237, R.drawable.g238, R.drawable.g239,
        R.drawable.g240, R.drawable.g241, R.drawable.g242, R.drawable.g243, R.drawable.g244 )

    // 音声再生用サウンドプールのインスタンス
    private lateinit var soundPool: SoundPool
    private var gacchan = 0
    private var captain = 0
    private var pirozangi = 0
    private var sososo = arrayOf(0,0,0)

    // 乱数生成用変数
    @RequiresApi(Build.VERSION_CODES.O)
    val a = LocalTime.now().second.toLong()
    private val r = Random(a)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // サウンドプールのもろもろの初期化
        val SPattr = AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH).build()
        soundPool = SoundPool.Builder().setAudioAttributes(SPattr).setMaxStreams(6).build()

        // 音声データのロード
        gacchan = soundPool.load(this, R.raw.gacchan, 1)
        captain = soundPool.load(this, R.raw.captain, 1)
        pirozangi = soundPool.load(this, R.raw.pirozangi, 1)
        sososo[0] = soundPool.load(this, R.raw.umami, 1)
        sososo[1] = soundPool.load(this, R.raw.sososo, 1)
        sososo[2] = soundPool.load(this, R.raw.umasososo, 1)

        // オープニング音声
        soundPool.setOnLoadCompleteListener { soundPool, sampleId, status ->
            if (status == 0) {
                soundPool.play(gacchan, 1.0f, 1.0f, 0, 0, 1.0f)
            }
        }

        // 最初の顔の設定
        val img = findViewById<ImageButton>(R.id.GacchanFace)
        img.setImageResource(g[r.nextInt(1,244)])

        // イメージボタンにがっちゃんリスナを設定
        val listener = GacchanListener()
        img.setOnClickListener(listener)
    }

    // がっちゃんリスナ
    private inner class GacchanListener : View.OnClickListener {
        override fun onClick(view: View) {
            val img = findViewById<ImageButton>(R.id.GacchanFace)
            // 1/500の確率でアキラさん
            if(r.nextInt(500) == 1) {
                soundPool.play(captain, 1.0f, 1.0f, 0, 0, 1.0f)
                img.setImageResource(g[0])
            } else {
                // 約1/50の確率でピロザンギ
                if(r.nextInt(50) == 1){
                    soundPool.play(pirozangi, 1.0f, 1.0f, 0, 0, 1.0f)
                    img.setImageResource(g[r.nextInt(1,3)])
                } else {
                    soundPool.play(sososo[r.nextInt(3)], 1.0f, 1.0f, 0, 0, 1.0f)
                    img.setImageResource(g[r.nextInt(3,244)])
                }
            }
        }
    }
    override fun onDestroy() {
        // お行儀よくサウンドプールは解放して終了
        soundPool.release()
        super.onDestroy()
    }
}