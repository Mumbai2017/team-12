from django.http import HttpResponse
from django.shortcuts import render
from MakeAWish.models import ChildProfile, Doctor, Volunteer, Donor, Transaction
from CFG.settings import TEMPLATE_PATH, STATIC_URL


# Create your views here.

def admin_panel(request):
    pending_wishes = ChildProfile.objects.filter(wish_status__lte=3).count()
    pending_approval = Volunteer.objects.filter(status=False).count()
    doc_list = Doctor.objects.all().count()
    active_donors = Donor.objects.all().count()
    context_dict = {'active_donors': active_donors, 'doc_list': doc_list, 'pending_wishes': pending_wishes,
                    'pending_approval': pending_approval}
    return render(request, TEMPLATE_PATH + '/MakeAWish/index.html', context_dict)


def wishes_panel(request):
    return render(request, TEMPLATE_PATH + '/MakeAWish/wishes.html')


def volunteer_panel(request):
    pending_approval = Volunteer.objects.filter(status=False).count()
    context_dict = {'pending': pending_approval}
    return render(request, TEMPLATE_PATH + '/MakeAWish/vol.html', context_dict)


def doctor_panel(request):
    return render(request, TEMPLATE_PATH + '/MakeAWish/doc.html')


def donoe_panel(request):
    methods = Donor.objects.get()
    return render(request, TEMPLATE_PATH + '/MakeAWish/donor.html', {'values': [['foo', 32], ['bar', 64], ['baz', 96]]})
