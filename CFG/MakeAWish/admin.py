from django.contrib import admin
from MakeAWish.models import ChildProfile, Donor, Doctor, Transaction, Volunteer
# Register your models here.

admin.site.register(ChildProfile)
admin.site.register(Doctor)
admin.site.register(Donor)
admin.site.register(Transaction)
admin.site.register(Volunteer)
