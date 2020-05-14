package project.android.allfiltersexample

import android.app.Application
import com.qw.soul.permission.SoulPermission

/**
 * User: wujinsheng1@yy.com
 * Date: 2020/5/14 17:24
 * ModifyTime: 17:24
 * Description:
 */
class XApp : Application() {
    override fun onCreate() {
        super.onCreate()
        SoulPermission.init(this)
    }
}