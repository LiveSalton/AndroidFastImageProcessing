package project.android.allfiltersexample

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.qw.soul.permission.SoulPermission
import com.qw.soul.permission.bean.Permission
import com.qw.soul.permission.bean.Permissions
import com.qw.soul.permission.callbcak.CheckRequestPermissionsListener
import cproject.android.allfiltersexample.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * User: wujinsheng1@yy.com
 * Date: 2020/5/14 17:04
 * ModifyTime: 17:04
 * Description:
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvAllFiltersExample.setOnClickListener {
            startActivity(Intent(this, AllFiltersExampleActivity::class.java))
        }
        tvGenericFilterExample.setOnClickListener {
            startActivity(Intent(this, GenericFilterExampleActivity::class.java))
        }
        tvTwoInputFilterExample.setOnClickListener {
            startActivity(Intent(this, TwoInputFilterExampleActivity::class.java))
        }
        tvVideoToImageExample.setOnClickListener {
            startActivity(Intent(this, VideoToImageExampleActivity::class.java))
        }



        SoulPermission.getInstance().checkAndRequestPermissions(
            Permissions.build(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA, Manifest.permission.MODIFY_AUDIO_SETTINGS
            )
            , object : CheckRequestPermissionsListener {
                override fun onAllPermissionOk(allPermissions: Array<out Permission>?) {
                    Log.i("TAG","onAllPermissionOk")
                }

                override fun onPermissionDenied(refusedPermissions: Array<out Permission>?) {
                    Log.i("TAG","onPermissionDenied")
                }

            })
    }
}