package com.food.app.firebase

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.food.app.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMsgService : FirebaseMessagingService() {


    override fun onNewToken(token: String) {
        super.onNewToken(token)

    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        if (message.notification != null) {
            message.notification?.title?.let {
                message.notification?.body?.let { it1 ->
                    showNotification(
                        it,
                        it1
                    )
                }
            }
            println("firebaseMsg:: ${message.notification?.title}")
        }
    }

    private fun cusDesign(title: String, msg: String): RemoteViews {
        val remoteViews = RemoteViews(
            applicationContext.packageName,
            R.layout.fb_notification
        )
        remoteViews.setTextViewText(R.id.appName, title)
        remoteViews.setTextViewText(R.id.notData, msg)
        return remoteViews
    }

    private fun showNotification(title: String, msg: String) {
        val channelId = "notification_channel"
        var builder =
            NotificationCompat.Builder(applicationContext, channelId)
                .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)

        builder = builder.setContent(cusDesign(title, msg))

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT
            >= Build.VERSION_CODES.O
        ) {
            val notificationChannel = NotificationChannel(
                channelId, "web_app",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(
                notificationChannel
            )
        }
        notificationManager.notify(0, builder.build())
    }
}