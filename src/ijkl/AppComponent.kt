package ijkl

import com.intellij.ide.IdeEventQueue
import com.intellij.notification.NotificationDisplayType.STICKY_BALLOON
import com.intellij.notification.NotificationsConfiguration
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.ApplicationComponent
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.util.SystemInfo
import java.awt.KeyboardFocusManager

class AppComponent: ApplicationComponent {

    override fun initComponent() {
        val logger = Logger.getInstance(this.javaClass.canonicalName)
        val application = ApplicationManager.getApplication()
        NotificationsConfiguration.getNotificationsConfiguration().register(groupDisplayId, STICKY_BALLOON, true)

        initEventReDispatch(
            ideEventQueue = IdeEventQueue.getInstance(),
            keyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager(),
            application = ApplicationManager.getApplication()
        )
    }

    override fun disposeComponent() {}

    override fun getComponentName() = AppComponent::javaClass.name
}
