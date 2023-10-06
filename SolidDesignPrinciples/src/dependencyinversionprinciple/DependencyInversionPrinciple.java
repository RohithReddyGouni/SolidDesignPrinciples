package dependencyinversionprinciple;


//Abstraction for a messaging service
interface MessagingService {
 void sendMessage(String message);
}

//Implementation for SMS messaging service
class SmsService implements MessagingService {
 @Override
 public void sendMessage(String message) {
     System.out.println("Sending SMS: " + message);
 }
}

//Implementation for email messaging service
class EmailService implements MessagingService {
 @Override
 public void sendMessage(String message) {
     System.out.println("Sending Email: " + message);
 }
}

//High-level module that depends on the messaging service abstraction
class NotificationService {
 private MessagingService messagingService;

 public NotificationService(MessagingService messagingService) {
     this.messagingService = messagingService;
 }

 public void sendNotification(String message) {
     // Delegate the actual sending of the message to the messaging service
     messagingService.sendMessage(message);
 }
}

public class DependencyInversionPrinciple {
 public static void main(String[] args) {
     // Create instances of messaging services
     MessagingService smsService = new SmsService();
     MessagingService emailService = new EmailService();

     // Create a notification service for SMS and email
     NotificationService smsNotificationService = new NotificationService(smsService);
     NotificationService emailNotificationService = new NotificationService(emailService);

     // Send notifications using the appropriate messaging service
     smsNotificationService.sendNotification("This is an SMS notification.");
     emailNotificationService.sendNotification("This is an email notification.");
 }
}
