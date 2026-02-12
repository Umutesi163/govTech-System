# Digital Government Service Management System

A Java-based OOP application inspired by platforms like Rwanda's Irembo. This system manages citizen applications for government services with file persistence, custom exceptions, and revenue reporting.

// Features
 (Citizen & Service Management): Model citizens and government services.
OOP Principles: Encapsulation, inheritance, abstraction, and polymorphism. :inlineCitations{data="&#91;&#123;&quot;url&quot;&#58;&quot;https&#58;//github.com/aytekinkaplan/Java-OOP-Projects&quot;,&quot;favicon&quot;&#58;&quot;https&#58;//imgs.search.brave.com/xxsA4YxzaR0cl-DBsH9-lpv2gsif3KMYgM87p26bs_o/rs&#58;fit&#58;32&#58;32&#58;1&#58;0/g&#58;ce/aHR0cDovL2Zhdmlj/b25zLnNlYXJjaC5i/cmF2ZS5jb20vaWNv/bnMvYWQyNWM1NjA5/ZjZmZjNlYzI2MDNk/N2VkNmJhYjE2MzZl/MDY5ZTMxMDUzZmY1/NmU3NWIzNWVmMjk0/NTBjMjJjZi9naXRo/dWIuY29tLw&quot;,&quot;title&quot;&#58;&quot;GitHub&#32;-&#32;aytekinkaplan/Java-OOP-Projects&#58;&#32;This&#32;repository&#32;contains&#32;...&quot;,&quot;snippet&quot;&#58;&quot;This&#32;repository&#32;serves&#32;as&#32;a&#32;showcase&#32;for&#32;various&#32;Java&#32;projects&#32;and&#32;exercises&#32;that&#32;demonstrate&#32;OOP&#32;principles&#32;such&#32;as&#32;inheritance,&#32;encapsulation,&#32;polymorphism,&#32;and&#32;abstraction.&#32;Each&#32;project&#32;is&#32;organized&#32;into&#32;its&#32;own&#32;directory&#32;with&#32;a&#32;detailed&#32;description&#32;of&#32;its&#32;purpose&#32;and&#32;functionality…&quot;&#125;&#93;"}
Application Lifecycle: Create, approve, and track applications (`PENDING`, `APPROVED`, `REJECTED`).
Custom Exceptions: `ApplicationNotFoundException`, `InvalidStatusTransitionException`.
File Persistence: Save/load applications to `applications.txt`.
Revenue Reporting: Generate reports from approved applications.

// Classes
( Class / Purpose )
( `Citizen` / Stores citizen details (ID, name, contact, etc.) )
( `GovernmentService` / Abstract base for all services )
( `BirthCertificateService`, `DrivingTestService` / Concrete services with validation rules )
( `ServiceApplication` / Tracks application status and metadata )
( `ApplicationManager` / Manages CRUD operations and file I/O )

